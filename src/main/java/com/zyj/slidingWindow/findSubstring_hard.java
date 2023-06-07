package com.zyj.slidingWindow;

import java.util.*;
import java.util.stream.Collectors;

import static jdk.nashorn.internal.objects.NativeString.substring;

/**
 * 给定一个字符串s和一个字符串数组words。words中所有字符串 长度相同。
 * s中的 串联子串 是指一个包含words中所有字符串以任意顺序排列连接起来的子串。
 * 例如，如果words = ["ab","cd","ef"]， 那么"abcdef"，"abefcd"，"cdabef"，"cdefab"，"efabcd"， 和"efcdab" 都是串联子串。"acdbef" 不是串联子串，因为他不是任何words排列的连接。
 * 返回所有串联字串在s中的开始索引。你可以以 任意顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
 * 子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
 * 子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
 * 输出顺序无关紧要。返回 [9,0] 也是可以的。
 * 示例 2：
 *
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 解释：因为 words.length == 4 并且 words[i].length == 4，所以串联子串的长度必须为 16。
 * s 中没有子串长度为 16 并且等于 words 的任何顺序排列的连接。
 * 所以我们返回一个空数组。
 *
 * 示例 3：
 *
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 * 解释：因为 words.length == 3 并且 words[i].length == 3，所以串联子串的长度必须为 9。
 * 子串 "foobarthe" 开始位置是 6。它是 words 中以 ["foo","bar","the"] 顺序排列的连接。
 * 子串 "barthefoo" 开始位置是 9。它是 words 中以 ["bar","the","foo"] 顺序排列的连接。
 * 子串 "thefoobar" 开始位置是 12。它是 words 中以 ["the","foo","bar"] 顺序排列的连接。
 *
 *
 *  "wordgoodgoodgoodbestword"
 * ["word","good","best","good"]
 */
public class findSubstring_hard {
    public static void main(String[] args) {
        String s= "barfoofoobarthefoobarman";
        String[] words = new String[]{"bar","foo","the"};
        List<Integer> substring = findSubstring(s, words);
        for (int i = 0; i < substring.size(); i++) {
            System.out.println(substring.get(i));
        }
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        if(s==null&&words==null&&words.length==0&&s.length()==0){
            return new ArrayList<>();
        }
        int lenth = s.length();
        int len = words[0].length();
        if(lenth < len* words.length){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if(map.containsKey(words[i])){
                map.put(words[i],map.get(words[i])+1);
            }else {
                map.put(words[i],1);
            }
        }
        for (int i = 0; i < lenth-len*words.length+1; i++) {
            String str =  s.substring(i,i+len*words.length);
            if(determine(str,map,len,words.length)){
                res.add(i);
            }
        }
        return res;
    }

    public static boolean determine(String s, Map<String,Integer> map,int len,int size){
        List<String> strList = getStrList(s, len, size);
        Map<String,Integer> temp = new HashMap<>();
        for (int i = 0; i < strList.size(); i++) {
            if(!map.containsKey(strList.get(i))){
                return false;
            }else {
                if(!temp.containsKey(strList.get(i))){
                    temp.put(strList.get(i),1);
                }else {
                    temp.put(strList.get(i),temp.get(strList.get(i))+1);
                }
                if(temp.get(strList.get(i))>map.get(strList.get(i))){
                    return false;
                }
            }
        }
        return true;
    }


    public static List<String> getStrList(String inputString, int length,
                                          int size) {
        List<String> list = new ArrayList<String>();
        for (int index = 0; index < size; index++) {
            String childStr = inputString.substring(index * length,
                    (index + 1) * length);
            list.add(childStr);
        }
        return list;
    }

}
