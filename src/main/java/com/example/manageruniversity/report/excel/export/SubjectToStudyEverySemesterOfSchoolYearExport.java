package com.example.manageruniversity.report.excel.export;

import com.example.manageruniversity.core.instruction.MajorSubjectSelection;
import lombok.Getter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

@Getter
public class SubjectToStudyEverySemesterOfSchoolYearExport extends Export {
    private List<MajorSubjectSelection> majorSubjectSelections;
    private String[] headers = {
            "Mã sinh viên",
            "Họ và tên",
            "Ngày sinh",
            "Chuyên ngành",
            "Khóa",
            "Chuyên cần",
            "Giữa kỳ",
            "Kiểm tra",
            "Cuối kỳ"};
    private String sheetName;

    public SubjectToStudyEverySemesterOfSchoolYearExport(List<MajorSubjectSelection> majorSubjectSelections, String sheetName) {
        this.sheetName = sheetName;
        this.majorSubjectSelections = majorSubjectSelections;
        setWorkbook(new XSSFWorkbook());
        setSheet(getWorkbook().createSheet(sheetName));
    }
    @Override
    protected void writeDataLines() {

    }
}
