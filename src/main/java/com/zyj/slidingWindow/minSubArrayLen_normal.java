package com.zyj.slidingWindow;

/**
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组[4,3]是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 */
public class minSubArrayLen_normal {
    public static void main(String[] args) {
        int[]nums = new int[]{2,3,1,2,4,3};
        int target = 7;
        System.out.println(minSubArrayLen(target,nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0,sum=0,right = 0;
        int res = Integer.MAX_VALUE;
        int len = nums.length;
        while (right<len){
            sum+=nums[right];
            while (sum>=target){
                res = Math.min((right-left+1),res);
                sum-=nums[left];
                left++;
            }
            right++;
        }
        return res==Integer.MAX_VALUE ?0:res;
    }
}
