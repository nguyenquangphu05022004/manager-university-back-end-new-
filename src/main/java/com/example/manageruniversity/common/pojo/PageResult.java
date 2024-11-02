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
    private String message;
    private Integer code;
    public static <Dto, Entity> PageResult<Dto> success(Page<Entity> page,
                                                        Function<Entity, Dto> func,
                                                        String message) {
        return new PageResult<>(
                page.getContent().stream().map(func).toList(),
                page.getNumber() + 1,
                page.getTotalPages(),
                message,
            200
        );
    }

    public static <Dto, Entity> PageResult<Dto> success(Page<Entity> page,
                                                        Function<Entity, Dto> func) {
        return success(page, func, null);
    }
}
