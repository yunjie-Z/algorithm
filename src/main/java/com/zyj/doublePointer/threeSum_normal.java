package com.zyj.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 *
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 *
 */
public class threeSum_normal {
    public static void main(String[] args) {
        int[]nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>res = new ArrayList<>();
        if(nums.length<3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if(nums[i]>0){
                break;
            }
            if(i>0&& nums[i]==nums[i-1]){
                continue;
            }
            int target = -nums[i];
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                if(nums[left]+nums[right]==target){
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                }else if(nums[left]+nums[right]<target){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }
}
