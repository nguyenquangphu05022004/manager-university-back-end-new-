package com.example.manageruniversity.common.collection;

import java.lang.reflect.Array;
import java.util.List;

public class ArrayUtils {

    public static <T> T[] convertToArray(List<T> collection, Class<?> clazz) {
        T[] arrays = (T[]) Array.newInstance(clazz, collection.size());
        int i = 0;
        for(var x : collection) {
            arrays[i] = x;
            i ++;
        }
        return arrays;
    }

}
