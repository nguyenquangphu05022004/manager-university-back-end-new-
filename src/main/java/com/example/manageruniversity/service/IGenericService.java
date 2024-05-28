package com.example.manageruniversity.service;

import java.util.List;

public interface IGenericService<Request, Response> {
    Response saveOrUpdate(Request request);
    List<Response> records();
    void delete(Long id);
}
