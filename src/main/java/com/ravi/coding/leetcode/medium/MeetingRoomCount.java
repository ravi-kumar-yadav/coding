package com.ravi.coding.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

// Problem: 253
// https://leetcode.com/problems/meeting-rooms-ii/
public class MeetingRoomCount {

    public int meetingRoomCount(int[][] intervals){
        // create a deep copy of intervals
        int[][] copy = new int[intervals.length][];
        int maxRoom = 0;

        for (int i=0; i<intervals.length; i++){
            copy[i] = intervals[i].clone();
        }

        // sort the copy by start time
        Arrays.sort(copy, (a, b) -> Integer.compare(a[0], b[0]));

        // create min priority queue to keep track of occupied rooms
        PriorityQueue<Integer> minPQ = new PriorityQueue<>( (a, b) -> Integer.compare(a, b));

        for (int[] interval: copy){
            // remove the element from minPQ if rooms aren't overlapping
            while (!minPQ.isEmpty() && minPQ.peek() <= interval[0]){
                minPQ.poll();
            }

            // add the element to minPQ
            minPQ.offer(interval[1]);

            maxRoom = Math.max(maxRoom, minPQ.size());
        }

        // return priority queue size as result
        return maxRoom;
    }
}
