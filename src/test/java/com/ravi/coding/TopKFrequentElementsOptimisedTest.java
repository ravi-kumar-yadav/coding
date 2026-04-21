package com.ravi.coding;


import com.ravi.coding.leetcode.medium.TopKFrequencyElementsOptimised;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TopKFrequentElementsOptimisedTest {
    private TopKFrequencyElementsOptimised topKFrequencyElementsOptimised;

    @BeforeEach
    void beforeEach(){
        topKFrequencyElementsOptimised = new TopKFrequencyElementsOptimised();
    }

    @Test
    void testSimpleOutput(){
        int[] input = { 1, 2, 1, 4, 2, 5, 2, 1};
        int k = 2;
        int[] expected = {1,2};

        int[] output = topKFrequencyElementsOptimised.topKElementsOptimised(input, k);

        System.out.println("Going to test simple case of frequency");
        assertArrayEquals(expected, output, "frequency should match");
        System.out.println("simple case of frequency passed!");
    }

    @Test
    void testEmptyInput(){
        int[] input = {};
        int k = 2;
        int[] expected = {};

        int[] output = topKFrequencyElementsOptimised.topKElementsOptimised(input, k);

        System.out.println("Going to test empty input");
        assertArrayEquals(expected, output, "output must be empty too");
        System.out.println("empty input passed!");
    }

    @Test
    void testZeroK(){
        int[] input = {1, 2, 3, 4, 2, 3, 1, 4};
        int k = 0;
        int[] expected = {};

        int[] output = topKFrequencyElementsOptimised.topKElementsOptimised(input, k);

        System.out.println("Going to test zero-k");
        assertArrayEquals(expected, output, "output must be empty too");
        System.out.println("zero-k passed!");
    }
}
