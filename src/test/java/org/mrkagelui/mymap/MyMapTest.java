package org.mrkagelui.mymap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMapTest {

    @Test
    void get() {
        MyMap<String, Integer> myMap = new MyMap<>();
        myMap.put("ATest", 999);
        assertTrue(999 == myMap.get("ATest"));
    }

    @Test
    void put() {
        MyMap<String, Integer> myMap = new MyMap<>();
        myMap.put("ATest", 1);
        assertEquals(1, myMap.size());
    }

    @Test
    void delete(){
        MyMap<Integer, String> oneMap = new MyMap<>();
        oneMap.put(1, "TEst");
        oneMap.delete(65);
        assertEquals(1, oneMap.size());
        oneMap.put(65, "Another test");
        assertEquals(2, oneMap.size());
        oneMap.delete(65);
        assertEquals(1, oneMap.size());
    }
}