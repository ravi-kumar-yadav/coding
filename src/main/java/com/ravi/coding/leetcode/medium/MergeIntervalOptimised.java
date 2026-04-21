package com.ravi.coding.leetcode.medium;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/
public class MergeIntervalOptimised {

    public int[][] mergeIntervals(int[][] input){
        int[][] intervals = new int[input.length][];
        List<int[]> output = new ArrayList<>();

        for(int i=0; i<input.length; i++){
            intervals[i] = input[i].clone(); // or intervals[i] = Arrays.copyOf(input[i], input[i].length);
        }

        // Sort the array based on start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int[] num: intervals){
            System.out.println("Interval: " + num[0] + ", " + num[1]);
        }

        for (int[] interval: intervals){
            if (output.size() == 0){
                output.add(interval);
            } else if (output.get(output.size()-1)[1] < interval[0]){
                output.add(interval);
            } else {
                output.get(output.size()-1)[1] = Math.max(output.get(output.size()-1)[1], interval[1]);
            }
        }

        // compute the response and return
        return output.toArray(new int[0][]);
    }
}
