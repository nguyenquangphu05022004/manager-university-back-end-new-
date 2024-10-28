package com.example.manageruniversity.common.collection;

import com.example.manageruniversity.common.object.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static <T> List<T> initList(T t) {
        List<T> list = new ArrayList<>();
        list.add(t);
        return list;
    }

    public static <T> List<T> toList(T[] values) {
        List<T> list = new ArrayList<>();
        for(T t : values) {
            list.add(t);
        }
        return list;
    }

    public static <T, M> List<T> convert(Class<T> classWantConvert, List<M> list) {
        if(CollectionUtils.isEmpty(list)) {
            return null;
        }
        final List<T> newList = new ArrayList<>();
        list.stream().forEach(s -> newList.add(ObjectUtils.init(classWantConvert, s)));
        return newList;
    }
}
