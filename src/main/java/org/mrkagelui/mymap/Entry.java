package org.mrkagelui.mymap;

public class Entry<K, V> {
    private K key;
    private V value;

    public Entry(K k, V v){
        key = k;
        value = v;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V v) {
        value = v;
    }
}
