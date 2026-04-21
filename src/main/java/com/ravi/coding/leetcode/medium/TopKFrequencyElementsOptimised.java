package com.ravi.coding.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

// Problem: 347
// https://leetcode.com/problems/top-k-frequent-elements/description/
public class TopKFrequencyElementsOptimised {

    public int[] topKElementsOptimised(int[] input, int k){

        if (input == null || input.length == 0 || k == 0){
            return new int[0];
        }

        Map<Integer, Integer> frequency = new HashMap<>();
        List<Integer>[] buckets = new List[input.length + 1];

        // create frequency map
        for (int num: input){
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        // populate bucket based on frequency
        for (int num: frequency.keySet()){
            int freq = frequency.get(num);

            if (buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(num);
        }

        // find top-k elements based on frequency
        int[] output = new int[k];
        int count = 0;

        for (int i=buckets.length-1; i>=0 && count<k; i--){
            if (buckets[i] != null){
                for (int num: buckets[i]){
                    output[count++] = num;

                    if (count == k){
                        break;
                    }
                }
            }
        }
        return output;
    }
}
