package com.ravi.coding;

import com.ravi.coding.leetcode.medium.NoOfIslands;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class NoOfIslandTest {

    private NoOfIslands noOfIslands;

    @BeforeEach
    void beforeEach(){
        noOfIslands = new NoOfIslands();
    }

    @Test
    void testEmpty(){
        char[][] input = {};
        int expected = 0;
        int output;

        output = noOfIslands.islandCount(input);

        System.out.println("Testing empty input case");
        assertEquals(expected, output, "Islands present should be 0");
        System.out.println("Empty input passed!");
    }

    @Test
    void testGrid(){
        char[][] input = {
                {'1', '0', '1'},
                {'1', '0', '0'},
                {'1', '0', '1'},
        };
        int expected = 3;
        int output;

        output = noOfIslands.islandCount(input);

        System.out.println("Testing grid case");
        assertEquals(expected, output, "Island present should be 3");
        System.out.println("Empty input passed!");
    }

}
