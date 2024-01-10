package com.zyj.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 */
public class wordPattern_easy {
    public static void main(String[] args) {

    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> map_p = new HashMap<>();
        Map<String,Character> map_s = new HashMap<>();

        String[] s1 = s.split(" ");
        if(pattern.length()!=s1.length){
            return false;
        }
        for (int i = 0; i < pattern.length(); i++) {
            char a = pattern.charAt(i);
            if((map_p.containsKey(a) && !map_p.get(a).equals(s1[i]))
                    ||(map_s.containsKey(s1[i]) && !map_s.get(s1[i]).equals(a))){
                return false;
            }
            map_p.put(a,s1[i]);
            map_s.put(s1[i],a);
        }
        return true;
    }
}
