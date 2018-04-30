package org.mrkagelui.mymap;

import java.util.ArrayList;
import java.util.List;

public class MyMap<K, V> {
    private static final int initialSize = 64;

    private int currentSize;

    private List<List<Entry>> entryLists;

    public MyMap() {
        currentSize = initialSize;
        entryLists = new ArrayList<List<Entry>>(currentSize);
    }

    public V get(K key) {
        return null;
    }

    public void put(K key, V value) {

    }

    private int getBucketIndex(int hashcode){
        return hashcode & (currentSize - 1);
    }
}
