package com.jianzhioffer.testCode;

/**
 * 剑指 Offer 05. 替换空格
 * 题目链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * 题目描述：请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 */
public class Demo3 {
    public static void main(String[] args) {
/*        String string = replaceSpace("We are happy.");
        System.out.println("result str =" + string);*/
        System.out.println(replaceDemo());
    }

    public static String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
                continue;
            }
            sb.append(s.charAt(i));
        }
        //System.out.println("reslut =" + sb.toString());
        return sb.toString();
    }

    /**
     * 官方的题解，因为是把空格换成%20，由一个字符变成了3个字符，
     * 所以考虑字符数组来处理
     *
     * @param s
     * @return
     */
    public static String replaceSpace2(String s) {
        char[] array = new char[s.length() * 3];
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size] = '0';
            } else {
                array[size] = s.charAt(i);
            }
        }
        s.replaceAll(" ", "%20");
        s.replace(' ', '2');
        //System.out.println("reslut =" + sb.toString());
        return new String(array, 0, size);
    }

    public String replaceSpace3(String s) {
        return s.replaceAll(" ", "%20");
    }

    /**
     * 自己写的string的replace(char,char)方法
     *
     * @return
     */
    public static String replaceDemo() {
        String str = "aabb cc";
        char oldChar = ' ';
        char newChar = '*';
        int length = str.length();
        char arr[] = new char[length];
        for (int i = 0; i < length; i++) {
            char value = str.charAt(i);
            arr[i] = (value == oldChar) ? newChar : value;
        }
        return new String(arr);
    }
}
