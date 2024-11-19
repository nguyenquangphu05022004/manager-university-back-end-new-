package com.example.manageruniversity.common.pojo;

import com.example.manageruniversity.common.collection.ListUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class PageResult <T>{
    private List<T> data;
    private Integer currentPage;
    private Integer totalPage;

    public PageResult() {

    }

    public PageResult(Page<T> page) {
        this.data = page.getContent();
        this.currentPage = page.getNumber() + 1;
        this.totalPage = page.getTotalPages();
    }

    public <U> PageResult(PageResult<U> pageResult, Function<U, T> func) {
        this.data = pageResult.data.stream().map(func).collect(Collectors.toList());
        this.currentPage = pageResult.currentPage;
        this.totalPage = pageResult.totalPage;
    }

}
