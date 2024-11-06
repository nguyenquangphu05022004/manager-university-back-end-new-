package com.example.manageruniversity.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;

@Data
@AllArgsConstructor
public class PageResult <T>{
    private List<T> data;
    private Integer currentPage;
    private Integer totalPage;
}
