package ru.technotrack.divlev.homework2.utils;

public interface DataStorage<K, V> {

    void put(K key, V value);

    V get(K key);

    boolean contains(K key);

}