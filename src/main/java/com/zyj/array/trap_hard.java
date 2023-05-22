package com.zyj.array;

/**
 * 给定n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 */
public class trap_hard {
    public static void main(String[] args) {
        int height[] = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    // 0 0 1 0 1 2 1 0 0 1 0 0
    // 0 0 1 0 1 2 1 0 1 2 1 2
    // 3 2 3 1 2 3 2 0 0 1 0 0
    public static int trap(int[] height) {
        int len = height.length;
        int res = 0;
        int[]left = new int[len];
        int[]right = new int[len];
        int leftMax = 0;
        int rightMax = 0;
        for (int i = 0; i < len; i++) {
            if(height[i]>leftMax){
                leftMax = height[i];
            }
            if(i>0&&height[i]<leftMax){
                left[i] = leftMax-height[i];
            }else {
                left[i] = 0;
            }
        }
        for (int j = len-1; j >=0; j--) {
            if(height[j]>rightMax){
                rightMax = height[j];
            }
            if(j<len-1&&height[j]<rightMax){
                right[j] = rightMax-height[j];
            }else {
                right[j] = 0;
            }
        }
        for (int i = 0; i < len; i++) {
            res+=Math.min(left[i],right[i]);
        }
        return res;
    }
}
