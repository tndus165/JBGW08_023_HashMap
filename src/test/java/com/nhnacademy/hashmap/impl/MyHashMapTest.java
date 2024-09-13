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
    assertTrue(map.containsKey("one"));
    assertFalse(map.containsKey("two"));
  }
  @Test
  void testContainsValue() {
    map.put("one", 1);
    assertTrue(map.containsValue(1));
    assertFalse(map.containsValue(2));
  }
  @Test
  void testRemove() {
    map.put("one", 1);
    map.remove("one");
    assertFalse(map.containsKey("one"));
    assertNull(map.get("one"));
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
  }

  @BeforeEach
  void setUp() {
    map = new MyHashMap<>();
  }
}
