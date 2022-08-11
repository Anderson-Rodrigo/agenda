package com.agendador.agenda.configuracao.infrastructure.utilities;

import java.io.Serializable;
import java.util.Objects;

public class KeyValue<K, V> implements Serializable {

    private final K key;
    private final V value;

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public KeyValue(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }

    @Override
    public int hashCode() {
        return key.hashCode() * 13 + (value == null ? 0 : value.hashCode());
    }

    @Override
    @SuppressWarnings("rawtypes")
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o instanceof KeyValue) {
            KeyValue pair = (KeyValue) o;
            if (!Objects.equals(key, pair.key))
                return false;
            return Objects.equals(value, pair.value);
        }
        return false;
    }

}
