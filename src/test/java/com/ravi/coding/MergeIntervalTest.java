package com.ravi.coding;

import com.ravi.coding.leetcode.medium.MergeInterval;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MergeIntervalTest {

    private MergeInterval mergeInterval;

    @BeforeEach
    void beforeEach(){
        mergeInterval = new MergeInterval();
    }

    @Test
    void testEmptyInput(){
        // setup
        int[][] input = {};
        int[][] expected = {};
        int[][] output;

        // execute
        output = mergeInterval.merge(input);

        // assert
        assertArrayEquals(expected, output, "Output should be empty for empty input");
    }

    @Test
    @DisplayName("Testing Null Input")
    void testNullInput(){
        // setup
        int[][] input = null;
        int[][] expected = null;
        int[][] output;

        // execute
        output = mergeInterval.merge(input);

        // assert
        assertNull(output, "Output should be empty for empty input");
    }
}
