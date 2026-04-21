package com.ravi.coding;

import com.ravi.coding.leetcode.medium.TopKFrequentElements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TopKFrequentElementsTest {

    private TopKFrequentElements topKFrequentElements;

    @BeforeEach
    void beforeEach(){
        topKFrequentElements = new TopKFrequentElements();
    }

    @Test
    void testOutputLength(){
        int[] input = {1, 7, 2, 3, 5, 1, 5, 7, 2, 5};
        int k = 1;
        int[] expected = {5};

        int[] output = topKFrequentElements.topKElements(input, k);

        System.out.println("Going to test the output length");
        assertArrayEquals(expected, output, "value should be " + Arrays.toString(expected));
        System.out.println("Length case test passed!");
    }

    @Test
    void testEmptyInput(){
        int[] input = {};
        int[] expected = {};
        int k = 2;
        int[] output = topKFrequentElements.topKElements(input, k);

        System.out.println("Going to test empty input");
        assertEquals(expected.length, output.length, "Output must be empty");
        System.out.println("Empty input passed!");
    }

    @Test
    void testEmptyK(){
        int[] input = {1, 1, 9, 9, 1, 2};
        int[] expected = {};
        int k = 0;
        int[] output = topKFrequentElements.topKElements(input, k);

        System.out.println("Going to test empty k");
        assertArrayEquals(expected, output, "Output must be empty!");
        System.out.println("Empty k passed!");

    }

    @Test
    @Disabled("As only one of the test case should be active at a time: testSortedAscending() or testSortedDescending()")
    void testSortedAscending(){
        int[] input = {3, 3, 9 , 9, 5, 3, 9, 4, 9, 5};
        int k = 3;
        int[] expected = {5, 3, 9};
        int[] output;

        output = topKFrequentElements.topKElements(input, k);

        System.out.println("Going to test output in ascending order of frequency");
        assertArrayEquals(expected, output, "output should be sort in ascending order of frequency");
        System.out.println("output in ascending order of frequency passed!");
    }

    @Test
    void testSortDescending(){
        int[] input = {3, 3, 9 , 9, 5, 3, 9, 4, 9, 5};
        int k = 3;
        int[] expected = {9, 3, 5};
        int[] output;

        output = topKFrequentElements.topKElements(input, k);

        System.out.println("Going to test output in descending order of frequency");
        assertArrayEquals(expected, output, "output should be sort in descending order of frequency");
        System.out.println("output in descending order of frequency passed!");
    }
}
