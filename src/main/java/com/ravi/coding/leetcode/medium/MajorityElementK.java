package com.ravi.coding.leetcode.medium;

import java.util.*;


// Problem: 229
// https://leetcode.com/problems/majority-element-ii/
public class MajorityElementK {

    public List<Integer> majorityElementK(int[] nums){
        Map<Integer, Integer> candidates = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int k = 3;

        // compute the Candidate Set
        for (int num: nums){
            if (candidates.containsKey(num)){
                candidates.put(num, candidates.get(num) + 1);
            } else if (candidates.size() < k-1){
                candidates.put(num, 1);
            } else {
                // decrement counter for all existing candidates
                Iterator<Map.Entry<Integer, Integer>> it = candidates.entrySet().iterator();

                while (it.hasNext()){
                    Map.Entry<Integer, Integer> entry = it.next();
                    entry.setValue(entry.getValue() - 1);
                    // remove candidates with count == 0
                    if (entry.getValue() == 0){
                        it.remove();
                    }
                }
            }
        }

        // validate the Candidate Set
        Map<Integer, Integer> freqCount = new HashMap<>();

        for(int num: nums){
            if (candidates.containsKey(num)){
                freqCount.put(num, freqCount.getOrDefault(num, 0) + 1);
            }
        }


        // populate the result (verified candidates only)
        for (int num: freqCount.keySet()){
            if (freqCount.get(num) > nums.length/k){
                result.add(num);
            }
        }

        return result;
    }
}
