package com.zyj.dataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 */
public class Intersect {
    public static void main(String[] args) {
        int num1[] = {1,2,2,1};
        int num2[] = {2,2};

        int[] intersect = intersect(num1, num2);
        for (int i : intersect) {
            System.out.println(i);
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length==0||nums2.length==0){
            return new int[0];
        }
        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums1) {
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else {
                map.put(i,1);
            }
        }
        for (int i : nums2) {
            if(map.containsKey(i)){
                res.add(i);
                int num = map.get(i)-1;
                if(num==0){
                    map.remove(i);
                }else {
                    map.put(i,num);
                }
            }
        }
        int[] result = new int[res.size()];
        int i=0;
        for (Integer re : res) {
            result[i] = re;
            i++;
        }
        return result;
    }
}
