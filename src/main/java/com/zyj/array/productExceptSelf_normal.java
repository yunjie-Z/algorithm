package com.zyj.array;

/**
 *给你一个整数数组nums，返回 数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。
 *
 * 题目数据 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
 *
 * 请不要使用除法，且在O(n) 时间复杂度内完成此题。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,4]
 * 输出: [24,12,8,6]
 * 示例 2:
 *
 * 输入: nums = [-1,1,0,-3,3]
 * 输出: [0,0,9,0,0]
 *
 */
public class productExceptSelf_normal {
    public static void main(String[] args) {
        int nums[] = new int[]{1,2,3,4};
        int result[] = productExceptSelf(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
    public static int[] productExceptSelf(int[] nums) {
        int lenth = nums.length;
        int left[] = new int[lenth];
        int right[] = new int[lenth];
        left[0] = 1;
        right[lenth-1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1]*nums[i-1];
        }
        for (int i = lenth-2; i >= 0; i--) {
            right[i] = right[i+1]*nums[i+1];
        }
        int result[] = new int[lenth];
        for (int i = 0; i < result.length; i++) {
            result[i] = left[i]*right[i];
        }
        return result;
    }
}
