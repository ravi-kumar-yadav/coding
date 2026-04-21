package com.ravi.coding;

import com.ravi.coding.leetcode.medium.MergeIntervalOptimised;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MergeIntervalOptimisedTest {
    MergeIntervalOptimised mergeIntervalOptimised;

    @BeforeEach
    void beforeEach(){
        mergeIntervalOptimised = new MergeIntervalOptimised();
    }

    @Test
    void testEmptyInputArray(){
        int[][] input = new int[0][0];
        int[][] output;

        output = mergeIntervalOptimised.mergeIntervals(input);

        System.out.println("Going to run: testEmptyInputArray()");
        assertEquals(0, output.length, "Lenght of output array should be 0");
    }

    @Test
    void testOverlappingArray(){
        int[][] input = new int[][]{
                {9, 10},
                {2, 4},
                {7, 9},
                {1, 3},
                {10, 11},
                {4, 6}
        };

        int[][] expected = new int[][]{
                {1, 6},
                {7, 11}
        };

        int[][] output;

        output = mergeIntervalOptimised.mergeIntervals(input);

        System.out.println("Going to run: testOverlappingArray()");
        assertEquals(expected.length, output.length, "Length of output array should be: " + expected.length);
        System.out.println("Length test passed!");

        for(int i=0; i<expected.length; i++){
            assertArrayEquals(expected[i], output[i], "Array not same");
            System.out.println("Value test passed for iteration: " + i);
        }
    }
}
