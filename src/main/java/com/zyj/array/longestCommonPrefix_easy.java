package com.zyj.array;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串""。
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 */
public class longestCommonPrefix_easy {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flowere"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        int i=0;
        boolean flag = true;
        int maxLenth  = strs[0].length();
        for (String str : strs) {
            maxLenth = Math.min(str.length(),maxLenth);
        }
        while (flag&&i<maxLenth){
            int length = strs.length;
            i++;
            String str = strs[0].substring(0,i);
            for (int j = 0; j < length; j++) {
                if(!str.equals(strs[j].substring(0,i))){
                    flag = false;
                    i--;
                    break;
                }
            }
        }
        return strs[0].substring(0,i);
    }
}
