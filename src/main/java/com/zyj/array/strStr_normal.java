package com.zyj.array;

/**
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果needle 不是 haystack 的一部分，则返回 -1 。

 * 示例 1：
 *
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 *
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 *
 */
public class strStr_normal {
    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issipi";
        System.out.println(strStr(haystack,needle));
    }

    public static int strStr(String haystack, String needle) {
        int length = haystack.length();
        int len = needle.length();
        if(length<len){
            return -1;
        }
        int index = 0;
        for (int i = 0; i < length; i++) {
            int j = i;
            while (haystack.charAt(j)==needle.charAt(index)&&(length-j>=len-index)){
                if(index==len-1){
                    return j-index;
                }
                index++;
                j++;
            }
            index=0;
        }
        return -1;
    }
}
