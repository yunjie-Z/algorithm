package com.zyj.array;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 * 示例1：
 *
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例2：
 *
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 *
 */
public class candy_hard {
    public static void main(String[] args) {
        int gas[] = new int[]{1,0,2};
        System.out.println(candy(gas));
    }

    public static int candy(int[] ratings) {
        int len = ratings.length;
        int res = 0;
        int[]left = new int[len];
        int[]right = new int[len];
        for (int i = 0; i < len; i++) {
            if(i>0&&ratings[i]>ratings[i-1]){
                left[i] = left[i-1]+1;
            }else {
                left[i] =1;
            }
        }
        for (int j = len-1; j >=0 ; j--) {
            if(j<len-1&&ratings[j]>ratings[j+1]){
                right[j] = right[j+1]+1;
            }else {
                right[j] =1 ;
            }
        }
        for (int i = 0; i < len; i++) {
            res += Math.max(left[i],right[i]);
        }
        return res;
    }
}
