package com.nhnacademy.hashmap.node;

/**
 * HashNode.
 *
 * @author woonseok
 * @Date 2024-09-13
 * @since 1.0
 **/
public class HashNode<K, V> {
    public K key;
    public V value;
    public HashNode<K, V> next;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public HashNode<K, V> getNext() {
        return next;
    }

    public void setNext(HashNode<K, V> next) {
        this.next = next;
    }

    public void displayNode() {
        System.out.println("Key: " + key + ", Value: " + value);
    }

    public static void main(String[] args) {
        // HashNode 인스턴스 만들기
        HashNode<String, Integer> node1 = new HashNode<>("one", 1);
        HashNode<String, Integer> node2 = new HashNode<>("two", 2);
        HashNode<String, Integer> node3 = new HashNode<>("three", 3);

        // 노드를 연결하여 체인을 시뮬레이션(충돌 처리)
        node1.setNext(node2);
        node2.setNext(node3);

        // 체인의 노드 표시
        System.out.println("HashNode chain:");
        HashNode<String, Integer> currentNode = node1;
        while(currentNode != null) {
            currentNode.displayNode();
            currentNode = currentNode.getNext();
        }
    }
}