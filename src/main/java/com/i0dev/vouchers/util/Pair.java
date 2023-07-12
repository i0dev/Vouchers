package com.i0dev.vouchers.util;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Pair<K, V> {
    K key;
    V value;

    @Override
    public String toString() {
        return key + "~" + value;
    }
}