package com.zyj.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 *
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 *
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 */
public class convert_normal {
    public static void main(String[] args) {
        String s = "A";
        int numRows = 1;
        System.out.println(convert(s,numRows));
    }

    public static String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        List<StringBuffer> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuffer(""));
        }
        int index;
        int lenth = s.length();
        for (int i = 0; i < lenth; i++) {
            int j = i/(numRows-1);
            if(j%2==0){
                index = i%(numRows-1);
            }else {
                index = numRows-1-i%(numRows-1);
            }
            list.get(index).append(s.charAt(i));
        }
        String res ="";
        for (StringBuffer stringBuffer : list) {
            res+=stringBuffer.toString();
        }
        return res;
    }
}
