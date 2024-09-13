// MyHashMap.java
package com.nhnacademy.hashmap.impl;

import com.nhnacademy.hashmap.IMap;
import com.nhnacademy.hashmap.node.HashNode;

import java.util.Objects;

/**
 * MyHashMap.
 *
 * @author woonseok
 * @Date 2024-09-13
 * @since 1.0
 **/
public class MyHashMap<K, V> implements IMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private HashNode<K, V>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = new HashNode[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public void clear() {
        table = new HashNode[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean containsKey(K key) {
        int index = getIndex(key);
        HashNode<K, V> node = table[index];
        while(node != null) {
            if(Objects.equals(node.key, key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for(HashNode<K, V> node : table) {
            while(node != null) {
                if(Objects.equals(node.value, value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        int index = getIndex(key);
        HashNode<K, V> node = table[index];
        while(node != null) {
            if(Objects.equals(node.key, key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V put(K key, V value) {
        if(size >= table.length * LOAD_FACTOR) {
            resize();
        }

        int index = getIndex(key);
        HashNode<K, V> node = table[index];
        while(node != null) {
            if(Objects.equals(node.key, key)) {
                V oldValue = node.value;
                node.value = value;
                return oldValue;
            }
            node = node.next;
        }
        node = new HashNode<>(key, value);
        node.next = table[index];
        table[index] = node;
        size++;
        return null;
    }

    @Override
    public void remove(K key) {
        int index = getIndex(key);
        HashNode<K, V> node = table[index];
        HashNode<K, V> prev = null;
        while(node != null) {
            if(Objects.equals(node.key, key)) {
                if(prev != null) {
                    prev.next = node.next;
                }
                else {
                    table[index] = node.next;
                }
                size--;
                return;
            }
            prev = node;
            node = node.next;
        }
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(K key) {
        return Objects.hashCode(key) % table.length;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        HashNode<K, V>[] oldTable = table;
        table = new HashNode[oldTable.length * 2];
        size = 0;

        for(HashNode<K, V> node : oldTable) {
            while(node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
    }
}
