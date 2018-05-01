package org.mrkagelui.mymap;

import java.util.ArrayList;
import java.util.List;

public class MyMap<K, V> {
    private static final int InitialCapacity = 64;
    private static final double LoadFactorThreshold = 0.75;

    private int currentCapacity;
    private int size;

    private List<List<Entry<K, V>>> entryLists;

    public MyMap() {
        currentCapacity = InitialCapacity;
        entryLists = new ArrayList<>(currentCapacity);
        for (int i = 0; i < currentCapacity; i++) {
            entryLists.add(new ArrayList<>());
        }
        size = 0;
    }

    public V get(K key) {
        List<Entry<K, V>> entries = getEntriesForKey(key);
        V ret = null;
        for (Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                ret = entry.getValue();
                break;
            }
        }
        return ret;
    }

    public boolean existsKey(K key) {
        List<Entry<K, V>> entries = getEntriesForKey(key);
        for (Entry e : entries) {
            if (e.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    private List<Entry<K, V>> getEntriesForKey(K key) {
        int bucket = getBucketIndex(key.hashCode());
        return entryLists.get(bucket);
    }

    public void put(K key, V value) {
        List<Entry<K, V>> entries = getEntriesForKey(key);

        if (existsKey(key)) {
            for (Entry e : entries) {
                if (e.getKey().equals(key)) {
                    e.setValue(value);
                }
            }
        }
        else {
            entries.add(new Entry<>(key, value));
            size++;
        }

        if ( (double)size / currentCapacity >= LoadFactorThreshold ) {
            expand();
        }
    }

    public void delete(K key) {
        List<Entry<K, V>> entries = getEntriesForKey(key);
        for (Entry entry : entries) {
            if (entry.getKey().equals(key)) {
                entries.remove(entry);
                size--;
                break;
            }
        }
    }

    private int getBucketIndex(int hashcode){
        return hashcode & (currentCapacity - 1);
    }

    private void expand() {
        currentCapacity *= 2;

        ArrayList<List<Entry<K, V>>> newEntryLists = new ArrayList<>(currentCapacity);
        for (int i = 0; i < currentCapacity; i++) {
            newEntryLists.add(new ArrayList<>());
        }

        for (List<Entry<K, V>> entryList : entryLists) {
            for (Entry e : entryList) {
                int newBucketIndex = getBucketIndex(e.getKey().hashCode());
                newEntryLists.get(newBucketIndex).add(e);
            }
        }

        entryLists = newEntryLists;
    }

    public int size() {
        return size;
    }
}
