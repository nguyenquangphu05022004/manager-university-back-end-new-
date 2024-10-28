package com.example.manageruniversity.common.collection;

import com.example.manageruniversity.handler.exception.ObjectNotFoundException;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class StreamUtils {


    public static <T> void filterAndThen(Collection<T> collection,
                                     Predicate<T> predicate,
                                     Consumer<T> consumer) {
        if(CollectionUtils.isEmpty(collection)) {
            return;
        }
        collection.stream()
                .filter(predicate)
                .forEach(consumer);
    }


    public static <T> T findFirst(Collection<T> collection,
                             Predicate<T> predicate) {
        if(CollectionUtils.isEmpty(collection)) {
            return null;
        }

        return collection.stream()
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }

    public static <T> boolean findAnyMatch(Collection<T> collection,
                                           Predicate<T> predicate) {
        if(CollectionUtils.isEmpty(collection)) {
            return false;
        }
        return collection
                .stream()
                .anyMatch(predicate);
    }
}

