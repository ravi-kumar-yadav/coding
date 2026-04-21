package com.ravi.coding;

import com.ravi.coding.leetcode.medium.NoOfIslandsOptimised;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NoOfIslandOptimisedTest {

    private NoOfIslandsOptimised noOfIslandsOptimised;

    @BeforeEach
    void beforeEach(){
        noOfIslandsOptimised = new NoOfIslandsOptimised();
    }

    @Test
    void testEmptyInput(){
        char[][] grid = {};
        int expected = 0;
        int output = noOfIslandsOptimised.islandCount(grid);

        System.out.println("Going to test empty input");
        assertEquals(expected, output, "empty input should generate 0");
        System.out.println("empty input passed!");
    }

    @Test
    void simpleInputTest(){
        char[][] grid = {
                {'1', '0', '1'},
                {'1', '0', '0'},
                {'1', '0', '1'},
        };
        int expected = 3;
        int output = noOfIslandsOptimised.islandCount(grid);

        System.out.println("Going to test simple input");
        assertEquals(expected, output, "simple input should generate 3");
        System.out.println("simple input passed!");
    }
}
