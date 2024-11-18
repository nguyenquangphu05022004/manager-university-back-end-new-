package com.example.manageruniversity.common.excel;

import com.example.manageruniversity.common.excel.annotation.ExcelProperties;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class ExcelUtils {

    public static <T> void export(Class<T> clazz,  List<T> list) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Map<String, String> stringStringMap = extractColumn(clazz, list.get(0));
    }

    static Map<String, String> extractColumn(Class clazz, Object t) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Map<String, String> res = new HashMap<>();
        Field[] field = clazz.getDeclaredFields();
        for(Field f : field) {
            ExcelProperties excelProperties = f.getDeclaredAnnotation(ExcelProperties.class);
            String name = Character.toUpperCase(f.getName().charAt(0)) + f.getName().substring(1);
            Method declaredMethod = clazz.getDeclaredMethod("get" + name);
            Object invoke = declaredMethod.invoke(t);
            if(excelProperties != null) {
                if(excelProperties.targetField() == TargetField.LIST) {
                    Map<String, String> vlz = new HashMap<>();
                    List list = new ArrayList((Collection)invoke);
                    for(Object item : list) {
                        Map<String, String> subVlz = extractColumn(excelProperties.targetObject(), item);
                        if(!subVlz.isEmpty()) {
                            subVlz.entrySet().forEach(entry -> {

                            });
                        }
                    }
                }
                else if(!excelProperties.targetObject().equals(Object.class)) {
                    Map<String, String> recursion = extractColumn(excelProperties.targetObject(), invoke);
                    res.putAll(recursion);
                } else {
                    res.put(excelProperties.column(), String.valueOf(invoke));
                }
            }
        }
        return res;
    }
}
