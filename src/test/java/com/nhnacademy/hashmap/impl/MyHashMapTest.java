// MyHashMapTest.java
package com.nhnacademy.hashmap.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * MyHashMap test.
 *
 * @author woonseok
 * @Date 2024-09-13
 * @since 1.0
 **/
class MyHashMapTest {
  //Todo 2. 구현한 MyHashMap을 적절히 테스트합니다.
  private MyHashMap<String, Integer> map;

  @Test
  void testPutAndGet() {
    map.put("one", 1);
    map.put("two", 2);
    assertEquals(1, map.get("one"));
    assertEquals(2, map.get("two"));
    assertNull(map.get("three"));
  }
  @Test
  void testContainsKey() {
    map.put("one", 1);
    map.put("two", 2);
    assertTrue(map.containsKey("one"));
    assertTrue(map.containsKey("two"));
    assertFalse(map.containsKey("three"));
  }
  @Test
  void testContainsValue() {
    map.put("one", 1);
    map.put("two", 2);
    assertTrue(map.containsValue(1));
    assertTrue(map.containsValue(2));
    assertFalse(map.containsValue(3));
  }
  @Test
  void testRemove() {
    map.put("one", 1);
    map.put("two", 2);
    map.remove("one");
    assertNull(map.get("one"));
    assertEquals(2, map.get("two"));
  }
  @Test
  void testSize() {
    assertEquals(0, map.size());
    map.put("one", 1);
    assertEquals(1, map.size());
    map.put("two", 2);
    assertEquals(2, map.size());
    map.remove("one");
    assertEquals(1, map.size());
  }
  @Test
  void testResize() {
    for(int i = 0; i < 20; i++) {
      map.put("key" + i, i);
    }
    for(int i = 0; i < 20; i++) {
      assertEquals(i, map.get("key" + i));
    }
  }
  @Test
  void testIsEmpty() {
    assertTrue(map.isEmpty());
    map.put("one", 1);
    assertFalse(map.isEmpty());
    map.remove("one");
    assertTrue(map.isEmpty());
  }
  @Test
  void testClear() {
    map.put("one", 1);
    map.put("two", 2);
    map.clear();
    assertTrue(map.isEmpty());
    assertEquals(0, map.size());
    assertNull(map.get("one"));
    assertNull(map.get("two"));
  }
  @BeforeEach
  void setUp() {
    map = new MyHashMap<>();
  }
}
