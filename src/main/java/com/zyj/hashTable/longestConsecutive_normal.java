package com.zyj.hashTable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class longestConsecutive_normal {

    public static void main(String[] args) {
        int[]nums = new int[]{100,4,200,1,3,2};
        longestConsecutive(nums);
    }
    public static int longestConsecutive(int[] nums) {

        if(nums.length ==0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        int maxLen = 1;
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if(set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            if(nums[i-1]+1==nums[i]){
                len++;
                maxLen = Math.max(len,maxLen);
            }else {
                len = 1;
            }
        }
        return maxLen;
    }
}
