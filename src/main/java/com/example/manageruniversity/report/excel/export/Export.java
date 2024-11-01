package com.example.manageruniversity.report.excel.export;

import lombok.Getter;
import lombok.Setter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Date;

@Getter
@Setter
public abstract class Export {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
//    protected void writeHeaderLine(String[] headers) {
//        Row row = sheet.createRow(0);
//        CellStyle style = workbook.createCellStyle();
//        XSSFFont font = workbook.createFont();
//        font.setBold(true);
//        font.setFontHeight(16);
//        style.setFont(font);
//        for(int i = 0; i < headers.length; i++) {
//            createCell(row, i, headers[i], style);
//        }
//    }
    protected void createCell(Row row, int columnCount, Object value, CellStyle style) {
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
    protected abstract void writeDataLines() ;
}
