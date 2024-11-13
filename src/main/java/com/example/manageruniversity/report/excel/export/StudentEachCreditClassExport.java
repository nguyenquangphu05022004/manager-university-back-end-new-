package com.example.manageruniversity.report.excel.export;


import com.example.manageruniversity.core.member.dal.entities.Student;
import lombok.Getter;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

@Getter
public class StudentEachCreditClassExport extends Export {
    private List<Student> students;
    private String[] headers = {"Mã sinh viên", "Họ và tên", "Ngày sinh", "Chuyên ngành", "Khóa", "Chuyên cần", "Giữa kỳ", "Kiểm tra", "Cuối kỳ"};
    private String sheetName;
    public StudentEachCreditClassExport(List<Student> students, String fileName) {
        sheetName = fileName;
        this.students = students;
        setWorkbook(new XSSFWorkbook());
        setSheet(getWorkbook().createSheet(sheetName));
    }

    @Override
    protected void writeDataLines() {
        int rowCount = 1;
        CellStyle style = getWorkbook().createCellStyle();
        XSSFFont font = getWorkbook().createFont();
        font.setFontHeight(14);
        style.setFont(font);
        for (var student : students) {
            Row row = getSheet().createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, student.getUsername(), style);
            createCell(row, columnCount++,student.getFullName(), style);
            createCell(row, columnCount++,student.getDateOfBirth(), style);
            createCell(row, columnCount++, student.getMajor().getName(), style);
            createCell(row, columnCount++,student.getCourse().getName(), style);
        }
    }
}
