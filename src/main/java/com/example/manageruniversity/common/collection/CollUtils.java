package com.example.manageruniversity.common.collection;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollUtils {

    public static boolean isEmpty(Collection<?> collection) {
        if(collection == null || collection.size() == 0) {
            return true;
        }
        return false;
    }

    public static <T, U> List<U> convertToList(Collection<T> from, Function<T, U> func) {
        if (CollUtils.isEmpty(from)) {
            return new ArrayList<>();
        }
        return from.stream().map(func).filter(Objects::nonNull).collect(Collectors.toList());
    }
    public static <T, U> Set<U> convertToSet(Collection<T> from, Function<T, U> func) {
        if (CollUtils.isEmpty(from)) {
            return new HashSet<>();
        }
        return from.stream().map(func).filter(Objects::nonNull).collect(Collectors.toSet());
    }

    public static<T> boolean hasAnyContains(Collection<T> col1, Collection<T> col2) {
        for(T x : col1) {
            if(col2.contains(x)) return true;
        }
        return false;
    }
}
