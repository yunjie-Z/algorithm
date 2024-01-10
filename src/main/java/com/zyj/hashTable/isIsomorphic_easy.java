package com.zyj.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 * 示例 1:
 *
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 *
 * 输入：s = "paper", t = "title"
 * 输出：true
 */
public class isIsomorphic_easy {
    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        System.out.println(isIsomorphic(s,t));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map_s = new HashMap<>();
        Map<Character,Character> map_t = new HashMap<>();
       
        for (int i = 0; i < s.length(); i++) {
            char c_s = s.charAt(i);
            char c_t = t.charAt(i);
            if((map_s.containsKey(c_s) && c_t!=map_s.get(c_s))||(map_t.containsKey(c_t) && c_s!=map_t.get(c_t))){
                return false;
            }
            map_s.put(c_s,c_t);
            map_t.put(c_t,c_s);
        }
        return true;
    }
}
