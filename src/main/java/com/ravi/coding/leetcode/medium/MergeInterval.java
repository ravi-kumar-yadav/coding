package com.ravi.coding.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/
public class MergeInterval {
	public int[][] merge(int[][] intervals){

		List<int[]> result = new ArrayList<>();

		// sort the intervals by start time
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

		// loop over intervals and merge the overlapping intervals into list
		for (int[] interval: intervals) {
			if (result.size() == 0){
				result.add(interval);
			} else if (result.get(result.size()-1)[1] < interval[0]) {
				result.add(interval);
			} else {
				result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1], interval[1]);
			}
		}

		// convert list to array and return
		return result.toArray(new int[0][]);
	}
}
