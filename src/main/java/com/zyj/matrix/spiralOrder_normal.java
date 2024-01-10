package com.zyj.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * [1,2,3]
 * [4,5,6]
 * [7,8,9]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 */
public class spiralOrder_normal {
    public static void main(String[] args) {
        int[][]matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> integers = spiralOrder(matrix);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int x=0,y=0,h=matrix.length-1,w=matrix[0].length-1;
        while (x<=w&&y<=h){
            //up由左向右
            for (int i = x; i <=w ; i++) {
                ans.add(matrix[y][i]);
            }
            //第y行已经遍历过
            y++;
            //right 由上向下
            for (int i = y; i <=h ; i++) {
                ans.add(matrix[i][w]);
            }
            //第w列已经遍历过
            w--;
            //down 由右向左
            for (int i = w; i >=x &&h>=y ; i--) {
                ans.add(matrix[h][i]);
            }
            //第h行已经遍历过
            h--;
            //left 由下向上
            for (int i = h; i >=y&&x<=w ; i--) {
                ans.add(matrix[i][x]);
            }
            //第x列已经遍历过
            x++;
        }
        return ans;
    }

}
