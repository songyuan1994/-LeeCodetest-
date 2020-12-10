package com.jianzhioffer.testCode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;


/**
 * 120. 三角形最小路径和
 * 链接：https://leetcode-cn.com/problems/triangle/
 * 题目描述：
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 有一个index，对应下标就index+n好了
 */
public class DailyTest1 {
    public static int value = 1;
    public static void main(String[] args) {
        List<List<Integer>> triangle = Arrays.asList(Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3));
        //System.out.println("sum =" + minimumTotal(triangle));
        String s = "111";
        String s1 = s;
        s1 = s1 + "test";
        System.out.println("s:" + s);
        System.out.println("s1: "+ s1);
        StringBuilder sb1 = new StringBuilder("s1");
        StringBuilder sb2 = sb1;
        sb2.append("test");
        System.out.println("sb1:" + sb1);
        System.out.println("sb2: "+ sb2);
    }

    /**
     * 这道题的关键就是动态规划算法。
     * 可以看到前置条件是由上到下求，并且是个等腰三角形
     * 那么0号位置跟尾部就已经是特殊定义的了，特殊处理。
     * 中间部分，只需要找到上一个的i-1跟i位置的最小值，然后就拿到了当前位置的和了。
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;
        int sum = triangle.get(0).get(0);
        int length = triangle.size();
        int[] result = new int[length];
        result[0] = triangle.get(0).get(0);
        for (int index = 1; index < length; index++) {
            result[index] = result[index - 1] + triangle.get(index).get(index);
            for (int j = index - 1; j > 0; --j) {
                result[j] = Math.min(result[j - 1], result[j]) + triangle.get(index).get(j);
            }
            result[0] += triangle.get(index).get(0);
        }
        int minTotal = result[0];
        for (int i = 1; i < length; ++i) {
            minTotal = Math.min(minTotal, result[i]);
        }
        return minTotal;
    }

}

