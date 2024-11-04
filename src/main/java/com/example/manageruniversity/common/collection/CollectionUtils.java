package com.example.manageruniversity.common.collection;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionUtils {

    public static boolean isEmpty(Collection<?> collection) {
        if(collection == null || collection.size() == 0) {
            return true;
        }
        return false;
    }
    public static <T, U> List<U> convertList(T[] from, Function<T, U> func) {
        if (ArrayUtils.isEmpty(from)) {
            return new ArrayList<>();
        }
        return convertList(Arrays.asList(from), func);
    }

    public static <T, U> List<U> convertList(Collection<T> from, Function<T, U> func) {
        if (CollectionUtils.isEmpty(from)) {
            return new ArrayList<>();
        }
        return from.stream().map(func).filter(Objects::nonNull).collect(Collectors.toList());
    }
}
