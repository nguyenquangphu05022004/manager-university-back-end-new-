package com.example.manageruniversity.common.pojo;

import lombok.Data;

import java.util.Objects;

@Data
public class KeyPair<K, V> {
    private K key;
    private V value;

    public KeyPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        KeyPair<?, ?> keyPair = (KeyPair<?, ?>) object;
        return Objects.equals(key, keyPair.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
