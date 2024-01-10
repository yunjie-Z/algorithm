package com.zyj.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 */
public class minWindow_hard {

    public static void main(String[] args) {
        String s = "ab";
        String t = "a";

        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String t) {
        HashMap<Character,Integer> hs = new HashMap<Character,Integer>();
        HashMap<Character,Integer> ht = new HashMap<Character,Integer>();
        for(int i = 0;i < t.length();i ++){
            ht.put(t.charAt(i),ht.getOrDefault(t.charAt(i), 0) + 1);
        }
        String ans = "";
        int len = 0x3f3f3f3f, cnt = 0;  //有多少个元素符合
        for(int i = 0,j = 0;i < s.length();i ++)
        {
            hs.put(s.charAt(i), hs.getOrDefault(s.charAt(i), 0) + 1);
            if(ht.containsKey(s.charAt(i)) && hs.get(s.charAt(i)) <= ht.get(s.charAt(i))) cnt ++;
            while(j < i && (!ht.containsKey(s.charAt(j)) || hs.get(s.charAt(j)) > ht.get(s.charAt(j))))
            {
                int count = hs.get(s.charAt(j)) - 1;
                hs.put(s.charAt(j), count);
                j ++;
            }
            if(cnt == t.length() && i - j + 1 < len){
                len = i - j + 1;
                ans = s.substring(j,i + 1);
            }
        }
        return ans;

    }
}
