package com.example.manageruniversity.courses.credit_class_schedule;

import com.example.manageruniversity.filter.Condition;
import org.springframework.data.domain.Page;

public interface CreditClassRegistrationScheduleService {
    /**
     *Tao thoi gian dang ky lop hoc tin chi cho sinh vien
     * theo khoa hoc cua ho cung voi nam hoc va chuyen nganh
     * @param request: thong tin de tao
     */
    CreditClassRegistrationSchedule create(CreditClassRegistrationScheduleRequest request);



//    /**
//     * lay toan bo thoi gian dang ky lop tin chi theo dieu kien
//     * nhu la chuyen nganh, khoa hoc, nam hoc
//     * @param condition: dieu kien
//     * Trong @param condition: Map<String, String>:
//     * string dau tien: Key de loc; string 2: gia tri loc
//     * Key se la MajorIdFilter(loc theo majorId) tuong tu nhung cai con lai
//     */
//    void getAllByCondition(Condition condition);

    Page<CreditClassRegistrationSchedule> getAllBySchoolYearId(Long schoolYearId, int page);
    Page<CreditClassRegistrationSchedule> getAllByMajorId(String majorId, int page);
}
