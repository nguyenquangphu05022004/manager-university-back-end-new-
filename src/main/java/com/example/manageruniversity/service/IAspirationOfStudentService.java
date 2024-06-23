package com.example.manageruniversity.service;

import com.example.manageruniversity.dto.AspirationRequest;
import com.example.manageruniversity.dto.AspirationResponse;

import java.util.List;

public interface IAspirationOfStudentService extends
        IGenericService<AspirationRequest, AspirationResponse> {

    List<AspirationResponse> getListAspirationByStudentIdAndAspirationRegisterId(
            Long studentId,
            Long aspirationRegisterId
    );
}
