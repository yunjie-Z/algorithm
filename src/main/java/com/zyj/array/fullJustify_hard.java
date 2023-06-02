package com.zyj.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单词数组words 和一个长度maxWidth，重新排版单词，使其成为每行恰好有maxWidth个字符，且左右两端对齐的文本。
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格' '填充，使得每行恰好有 maxWidth个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 注意:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于maxWidth。
 * 输入单词数组 words至少包含一个单词。
 * 
 *
 * 示例 1:
 *
 * 输入: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * 输出:
 * [
 *  "This  is  an",
 *  "example of text",
 *  "justification. "
 * ]
 *
 * []
 *
 */
public class fullJustify_hard {
    
    public static void main(String[] args) {
        String[]words = new String[]{"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;
        List<String> res = new ArrayList<>();
        res=  fullJustify(words,maxWidth);
        //System.out.println(combination(words,0,2,16));
        for (String re : res) {
            System.out.println(re);
        }
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int lenth = words.length;
        int left = 0,right = 0;
        int num = 0;
        while (left<lenth&&right<lenth){
            num += words[right].length();
            if(num+right-left>maxWidth){
                result.add(combination(words,left,right-1,maxWidth));
                left = right;
                right--;
                num = 0;
            }
            if(right==lenth-1){
                String str = "";
                for (int i = left; i < right; i++) {
                    str += words[i]+" ";
                }
                str+=words[right];
                str += blank(maxWidth-str.length());
                result.add(str);
            }
            right++;
        }
        return result;
    }

    // blank 返回长度为 n 的由空格组成的字符串
    public static String blank(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            sb.append(' ');
        }
        return sb.toString();
    }

    public static String combination(String[] words,int left,int right,int maxWidth){
        int num = maxWidth;
        for (int i = left; i <=right ; i++) {
            num =num - words[i].length();
        }
        if(left == right){
            return words[left]+blank(num);
        }
        int size =  num/(right-left);
        int remainder = num%(right-left);
        String res = "";
        for (int i = left; i <right ; i++) {
            if(remainder>0){
                res += words[i]+blank(size+1);
            }else {
                res += words[i]+blank(size);
            }
            remainder--;
        }
        return res+words[right];
    }


}
