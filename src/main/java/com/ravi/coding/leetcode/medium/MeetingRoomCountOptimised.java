package com.ravi.coding.leetcode.medium;

import java.util.Arrays;

public class MeetingRoomCountOptimised {

    public int meetingRoomCount(int[][] intervals){
        int len = intervals.length;
        int[][] copy = new int[len][];

        // do a deep clone
        for (int i=0; i<len; i++){
            copy[i] = intervals[i].clone();
        }

        // create two arrays to store start and end times
        int[] start = new int[len];
        int[] end = new int[len];

        for (int i=0; i<len; i++){
            start[i] = copy[i][0];
            end[i] = copy[i][1];
        }

        // Sort these two arrays
        Arrays.sort(start);
        Arrays.sort(end);

        // compute the maxRoom in a separate variable
        int i=0, j=0, rooms=0, maxRooms=0;

        while(i<len){
            if (start[i]<end[j]){
                rooms++;
                i++;
            } else {
                rooms--;
                j++;
            }

            maxRooms = Math.max(maxRooms, rooms);
        }

        return maxRooms;
    }
}
