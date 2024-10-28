package com.example.manageruniversity.common.pojo;

import lombok.Data;

@Data
public class KeyPair<K, V> {
    private K key;
    private V value;

    public KeyPair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
