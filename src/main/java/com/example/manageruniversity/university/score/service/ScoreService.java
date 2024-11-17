package com.example.manageruniversity.university.score.service;

import com.example.manageruniversity.university.score.dal.entity.Score;

import java.util.List;

public interface ScoreService {
    /**
     * Moi sinh vien deu dang ki mot nhom mon hoc
     * trong hoc ki do, va moi mon hoc deu co cac
     * dau diem thanh phan khac nhau theo tung hoc ky.
     * Cac thong tin chi tiet do can duoc duyet truoc khi khoi tao diem
     *
     * Day la phuong thuc khoi tao diem cho sinh vien tuy
     * thuoc vao mon hoc ma se co cac tieu chi danh gia khac nhau
     * nhu la % diem chuyen can, % diem bai tap lon, vv.
     *
     * @param schoolYearId: id cua hoc ki sinh vien dang hoc
     */
    void initForAllStudentBySchoolYearId(Long schoolYearId);


    /**
     * Lay toan bo diem cac mon hoc theo ky
     * ma sinh vien da hoc xong
     * @param studentId
     */
    List<Score> getAllByStudentId(Long studentId);
}
