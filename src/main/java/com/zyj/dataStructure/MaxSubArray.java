package com.zyj.dataStructure;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[]num = {5,4,-1,7,8};
        System.out.println(maxSubArray(num));
    }
    public static int maxSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int len = nums.length;
        int dp[] = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if(dp[i-1]<0){
                dp[i] = nums[i];
            }else {
                dp[i] = nums[i]+dp[i-1];
            }
        }
        int max = dp[0];
        for (int i = 0; i < len; i++) {
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
