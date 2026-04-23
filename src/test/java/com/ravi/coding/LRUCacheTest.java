package com.ravi.coding;

import com.ravi.coding.leetcode.medium.LRUCache;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class LRUCacheTest {
    private LRUCache lruCache;

    @BeforeEach
    void beforeEach(){
        lruCache = new LRUCache(2);
    }


    @Test
    void emptyCacheTest(){
        int expected = -1;

        System.out.println("Going to test empty LRU cache");
        assertEquals(expected, lruCache.get(5), "Empty cache should return -1");
        System.out.println("empty LRU cache passed!");
    }


    @Test
    void normalOpsTest(){
        int expectedOne = 1;
        int expectedTwo = 2;

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);

        System.out.println("Going to test simple LRU cache");
        assertEquals(expectedOne, lruCache.get(1), "Simple cache should return " + expectedOne);
        assertEquals(expectedTwo, lruCache.get(2), "Simple cache should return " + expectedTwo);
        System.out.println("Simple LRU cache passed!");
    }


    @Test
    void capacityOverflowTest(){
        int expectedOne = 1;
        int expectedTwo = 2;
        int expectedThree = -1;

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        lruCache.put(5, 5);
        lruCache.put(1, 1);
        lruCache.put(2, 2);

        System.out.println("Going to test capacity overflow LRU cache");
        assertEquals(expectedOne, lruCache.get(1), "Cache should return " + expectedOne);
        assertEquals(expectedTwo, lruCache.get(2), "Empty cache should return " + expectedTwo);
        assertEquals(expectedThree, lruCache.get(3), "Empty cache should return " + expectedThree);
        System.out.println("capacity overflow LRU cache passed!");
    }
}
