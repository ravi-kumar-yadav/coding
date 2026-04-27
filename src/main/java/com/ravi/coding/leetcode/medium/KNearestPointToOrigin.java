package com.ravi.coding.leetcode.medium;

import java.util.PriorityQueue;

// Problem: 973
// https://leetcode.com/problems/k-closest-points-to-origin/description/
public class KNearestPointToOrigin {

    public int[][] kNearestPointToOrigin(int[][] input, int k){
        PriorityQueue<int[]> maxPQ = new PriorityQueue<>( (a, b) ->
                (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));

        // create a max priority queue to store only k elements
        for (int[] eachInput: input){
            maxPQ.offer(eachInput);

            // remove element from priority queue if size > k
            if (maxPQ.size() > k){
                maxPQ.poll();
            }
        }

        // return the max priority queue
        return maxPQ.toArray(new int[0][]);
    }
}
