package com.ravi.coding;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ravi.coding.leetcode.medium.MergeInterval;

//@SpringBootTest
class DemoApplicationTest {
	private MergeInterval mergeInterval;

	@BeforeAll
	static void beforeAll(){
		System.out.println("Before All...");
	}

	@AfterAll
	static void afterAll(){
		System.out.println("After All...");
	}

	@BeforeEach
	void beforeEach(){
		// Setup
		mergeInterval = new MergeInterval();
		System.out.println("Before Each...");
	}

	@AfterEach
	void afterEach(){
		System.out.println("After Each...");
	}

	@Test
	@DisplayName("Checking output array length")
	void checkMergeIntervalsLength() {
		int[][] input = {
			{1, 3},
			{3, 7},
			{9, 10}
		};

		int[][] expected = {
			{1, 7},
			{9, 10}
		};

		// Execute
		int[][] result = mergeInterval.merge(input);

		// Assert
		System.out.println("Testing length of expected and real output");
		assertEquals(expected.length, result.length, "Number of intervals mismatch");
	}



	@Test
	@DisplayName("Checking each array values")
	void checkMergeIntervalsValue() {
		int[][] input = {
			{1, 3},
			{3, 7},
			{9, 10}
		};

		int[][] expected = {
			{1, 7},
			{9, 10}
		};

		// Execute
		int[][] result = mergeInterval.merge(input);

		// Assert
		for (int i = 0; i < expected.length; i++) {
			System.out.println("Checking each column value");
			assertArrayEquals(expected[i], result[i], "Interval at index " + i + " mismatches");
		}
	}
}
