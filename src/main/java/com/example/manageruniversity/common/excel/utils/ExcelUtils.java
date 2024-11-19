package com.example.manageruniversity.common.excel.utils;

import com.example.manageruniversity.common.excel.annotation.ExcelProperties;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.manageruniversity.common.collection.ListUtils.convertToList;

@Slf4j
public class ExcelUtils {
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;
    public static <T> void write(HttpServletResponse response,
                                 String sheetName,
                                  Class<T> clazz,
                                  List<T> list) {
       workbook = new XSSFWorkbook();
       sheet = workbook.createSheet(sheetName);
        List<Map<String, Object>> mapList = list.stream()
                .map(s -> extractColumn(clazz, s))
                .collect(Collectors.toList());

        List<String> headers = convertToList(mapList.get(0).entrySet(), s -> s.getKey());

        List<List<Object>> valueEachRow = convertToList(mapList, s -> convertToList(s.entrySet(), m -> m.getValue()));

        writeHeaderLine(headers);
        writeDataLines(valueEachRow);


    }


    private static void writeHeaderLine(List<String> headers) {
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        for(int i = 0; i < headers.size(); i++) {
            createCell(row, i, headers.get(0), style);
        }
    }

    private static void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else if (value instanceof String){
            cell.setCellValue((String) value);
        } else if(value instanceof Date) {
            cell.setCellValue((Date) value);
        }
        cell.setCellStyle(style);
    }


    static Map<String, Object> extractColumn(Class clazz, Object t) {
        try {
            Map<String, Object> res = new LinkedHashMap<>();
            Field[] field = clazz.getDeclaredFields();
            for(Field f : field) {
                ExcelProperties excelProperties = f.getDeclaredAnnotation(ExcelProperties.class);
                String name = Character.toUpperCase(f.getName().charAt(0)) + f.getName().substring(1);
                Method declaredMethod = clazz.getDeclaredMethod("get" + name);
                Object invoke = declaredMethod.invoke(t);
                if(excelProperties != null) {
                    if(!excelProperties.targetObject().equals(Object.class)) {
                        Map<String, Object> recursion = extractColumn(excelProperties.targetObject(), invoke);
                        res.putAll(recursion);
                    } else {
                        res.put(excelProperties.column(), String.valueOf(invoke));
                    }
                }
            }
            return res;
        } catch (Exception e) {
            log.error("Loi extract column excel");
            throw new RuntimeException(e);
        }
    }


    private static void writeDataLines(List<List<Object>> valueEachRows) {

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        int rowCount = 1;
        for(List<Object> eachRow : valueEachRows) {
            Row row = sheet.createRow(rowCount++);
            for(int j = 0; j < eachRow.size(); j ++) {
                createCell(row, j, eachRow.get(j), style);
            }
        }
    }
}
