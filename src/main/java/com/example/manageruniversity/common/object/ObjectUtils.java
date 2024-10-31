package com.example.manageruniversity.common.object;

import com.example.manageruniversity.common.collection.ArrayUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ObjectUtils {

    public static boolean isNull(Object object) {
        if(object == null) {
            return true;
        }
        return false;
    }

    public static <T> T init(Class<T> clazzInit, Object...prams) {
        try {
            List<Class<?>> classes = new ArrayList<>();
            for(var field : clazzInit.getDeclaredFields()) {
                classes.add(field.getType());
            }
            Constructor<T> constructor = clazzInit.getConstructor(
                    ArrayUtils.convertToArray(classes, Class.class)
            );
            return constructor.newInstance(prams);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Kiem tra cac gia tri cua tung thuoc tinh co != null or empty hay khong
     * neu empty or null se nem ngoai le
     * con khong thi ok
     * @param o: object can kiem tra
     */
    public static <T> void throwIfContainsAttributeIsNullOrEmpty(T o) {
    }

    /**
     * Tuong tu nhu ham o tren.
     * chi co dieu no se khong check nhung thuoc tinh duoc them vao parameter
     * @param o: object can kiem tra
     * @param exceptAttributes: cac thuoc tinh se duoc ignore
     */
    public static <T> void throwIfContainsAttributeIsNullOrEmpty(T o, String... exceptAttributes) {
    }
}
