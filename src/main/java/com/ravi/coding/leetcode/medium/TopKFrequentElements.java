package com.ravi.coding.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Problem: 347
// https://leetcode.com/problems/top-k-frequent-elements/description/
public class TopKFrequentElements {

    public int[] topKElements(int[] input, int k){

        if (input == null || input.length == 0 || k == 0){
            return new int[0];
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // count frequency
        for (int num: input){
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // create min priority-queue
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(frequencyMap.get(a), frequencyMap.get(b)));

        // keep only top k elements in min priority queue
        for (int num: frequencyMap.keySet()){
            pq.offer(num);

            if (pq.size() > k){
                pq.poll();
            }
        }

        int j=0;
        int[] result = new int[k];

        // provide output in ascending order of frequency
        while (!pq.isEmpty()){
            result[j++] = pq.poll();
        }

        // update result in descending order of frequency
        for (int i=0; i<result.length/2; i++){
            int temp = result[i];
            result[i] = result[result.length-i-1];
            result[result.length-i-1]  = temp;
        }

        return result;
    }
}
