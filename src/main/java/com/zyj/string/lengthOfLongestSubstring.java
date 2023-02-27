package com.zyj.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 给定一个字符串 s,请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class lengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(getLenth("abcabcbb"));
    }

    public static int getLenth(String s){
      if(s.length()==0){
          return 0;
      }
      Map<Character,Integer> map = new HashMap<>();
      int left = 0;
      int max = 0;
      for (int i = 0; i < s.length(); i++) {
          if(map.containsKey(s.charAt(i))){
              left = Math.max(left,map.get(s.charAt(i))+1);
          }
          map.put(s.charAt(i),i);
          max = Math.max(max,i-left+1);
      }
      return max;
    }
}
