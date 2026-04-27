package com.ravi.coding.leetcode.medium;

import java.util.Arrays;
import java.util.TreeMap;

// Problem: No direct mapping
//
public class MinVehicleAllocationOptimised {

    public int minVehicleAllocationOptimised(int[] orders, int[] vehicles) {
        int vehicleCount = 0;
        Arrays.sort(orders);
        reverseSortedArray(orders);

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int vehicle: vehicles){
            map.put(vehicle, map.getOrDefault(vehicle, 0) + 1);
        }

        for (int order: orders){
            Integer cap = map.ceilingKey(order);

            if (cap == null){
                return -1;
            }

            if (map.get(cap) == 1){
                map.remove(cap);
            } else {
                map.put(cap, map.get(cap) - 1);
            }

            int remaining = cap - order;

            if (remaining > 0){
                map.put(remaining, map.getOrDefault(remaining, 0) + 1);
            }
        }

        return vehicleCount;
    }

    private void reverseSortedArray(int[] arr){
        int i=0, j= arr.length-1;
        int temp;

        while (i<j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }
}
