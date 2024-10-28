package com.example.manageruniversity.common.collection;

import com.example.manageruniversity.common.pojo.KeyPair;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUtils {

    public static <K, V> Map<K, V> convertToMap(Collection<KeyPair<K, V>> keyPairs) {
        if(CollectionUtils.isEmpty(keyPairs)) {
            return null;
        }
        Map<K, V> map = new HashMap<>();
        keyPairs.stream()
                .forEach(pair -> {
                    map.put(pair.getKey(), pair.getValue());
                });
        return map;
    }
    public static <K, V> Map<K, List<V>> convertToMap(List<KeyPair<K, V>> keyPairs) {
        if(CollectionUtils.isEmpty(keyPairs)) {
            return null;
        }
        Map<K, List<V>> map = new HashMap<>();
        keyPairs.stream()
                .forEach(pair -> {
                    if(map.containsKey(pair.getKey())) {
                        map.get(pair.getKey()).add(pair.getValue());
                    } else {
                        map.put(pair.getKey(), ListUtils.initList(pair.getValue()));
                    }
                });
        return map;
    }
}
