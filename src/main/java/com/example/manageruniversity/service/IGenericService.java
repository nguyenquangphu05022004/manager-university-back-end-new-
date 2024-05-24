package com.example.manageruniversity.service;

import java.sql.SQLException;
import java.util.List;

public interface IGenericService<Request, Response> {
    Response saveOrUpdate(Request request);
    List<Response> records();
    void delete(Long id);
}
