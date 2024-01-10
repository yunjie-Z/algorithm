package com.zyj.hashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class containsNearbyDuplicate_normal {

    public static void main(String[] args) {
        int[]nums = new int[]{1,2,3,1,2,3};
        containsNearbyDuplicate(nums,2);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(i>k){
                set.remove(nums[i-k-1]);
            }
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else {
                return true;
            }
        }
        return false;
    }
}
