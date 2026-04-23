package com.ravi.coding.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

// Problem: 146
// https://leetcode.com/problems/lru-cache/description/
public class LRUCache {

    class Node{
        int key, value;
        Node prev, next;

        Node(int k, int v){
            key = k;
            value = v;
        }
    }

    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    private Map<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity){
        this.map = new HashMap<>();
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next= node;
    }

    private void removeNode(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);
        removeNode(node);
        addNode(node);

        return node.value;
    }

    public void put(int key, int value){
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addNode(node);
        } else {
            Node node = new Node(key, value);
            addNode(node);
            map.put(key, node);

            if (map.size() > capacity) {
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }
        }
    }
}
