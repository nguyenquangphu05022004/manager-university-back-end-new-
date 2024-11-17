package com.example.manageruniversity.university.course;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Thong tin de tao khoa hoc")
public class CourseRequest {
    @Schema(description = "Id khoa hoc", requiredMode = Schema.RequiredMode.REQUIRED, example = "D22")
    private String courseId;
    @Schema(description = "Khoa hoc duoc tao nam nao", requiredMode = Schema.RequiredMode.REQUIRED, example = "2022")
    private String name;
}
