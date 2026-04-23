package com.ravi.coding.leetcode.easy;


// Problem: 169
// https://leetcode.com/problems/majority-element/description/
public class MajorityElement {

    public int majorityElement(int[] nums){

        int candidate = 0;
        int count = 0;

        // find the candidate
        for (int num: nums){
            if (count == 0){
                candidate = num;
            }

            if (candidate == num){
                count++;
            } else {
                count--;
            }
        }

        // validate the candidate
        count = 0;
        for (int num: nums){
            if (candidate == num){
                count++;
            }
        }

        if (count > nums.length/2){
            return candidate;
        } else {
            return -1;
        }
    }
}
