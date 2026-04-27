package com.ravi.coding.leetcode.medium;

import java.util.Arrays;

// Problem: No direct mapping
//
public class MinVehicleAllocation {

    public int minVehicleAllocation(int[] vehicles, int[] orders){
        int vehicleCount = 0;

        // sort order in desc
        Arrays.sort(orders);
        Arrays.sort(vehicles);
        reverseSortedArray(orders);

        // copy vehicles to remaining
        int[] remaining = vehicles.clone();

        // check for availability and perform assignment
        for (int order: orders){
            boolean isPlaced = false;

            for (int i=0; i<remaining.length; i++){
                if (order <= remaining[i]){
                    remaining[i] -= order;
                    isPlaced = true;
                    break;
                }
            }

            if (isPlaced == false){
                return -1;
            }
        }

        // scan and count actual vehicle used
        for (int i=0; i<vehicles.length; i++){
            if (remaining[i] < vehicles[i]){
                vehicleCount++;
            }
        }

        return vehicleCount;
    }

    private void reverseSortedArray(int[] arr){
        int temp;

        for(int i=0; i<arr.length/2; i++){
            temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
    }
}
