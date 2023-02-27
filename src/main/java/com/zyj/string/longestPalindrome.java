package com.zyj.string;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 */

public class longestPalindrome {

    public static void main(String[] args) {
        System.out.println(centerExpansion("sabadab"));
    }

    /**
     * 动态规划
     */
    public static String dynamicProgramming(String s){
        return "";
    }

    /**
     * 中心扩展 O(n²)
     */
    public static String centerExpansion(String s){
        if(s==null||s.length()<1){
            return "";
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = centerAround(i,i,s);
            int len2 = centerAround(i,i+1,s);
            int lenth = Math.max(len1,len2);
            if(lenth>right-left){
                left = i-(lenth-1)/2;
                right = i+lenth/2;
            }
        }
        return s.substring(left,right+1);
    }

    public static int centerAround(int left,int right,String s){
        while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        //此时的right和left已超过回文范围，所以要减2
        return right-left+1-2;
    }

}
