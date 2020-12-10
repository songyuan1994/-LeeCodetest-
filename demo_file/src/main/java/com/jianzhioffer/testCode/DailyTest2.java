package com.jianzhioffer.testCode;

/**
 * 96. 不同的二叉搜索树
 * 题目链接：https://leetcode-cn.com/problems/unique-binary-search-trees/
 * 题目描述：给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class DailyTest2 {
    public static void main(String[] args) {
        //中间的话，可以考虑根节点，那么不能为最小跟最大，只能中间数
        //中间数为根的话，左边要比它小，右边要比它大。找出比它小的数的个数，放左边，
        // 比它大的数的个数，放右边。以此循环即可。
        numTrees2(3);
    }

    public static int numTrees(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == n) {
                sum += factorial(n - 1);
            } else {
                sum += factorial(i - 1) * factorial(n - i);
            }
        }
        System.out.println(sum);
        return sum;
    }

    public static int numTrees2(int n){
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    /**
     * 计算阶乘
     *
     * @param n
     * @return
     */
    private static long factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            long num = n * factorial(n - 1);
            return num;
        }
    }


    private static long factorial2(int n) {
        long num = 1;
        for (int i = 1; i <= n; i++) {
            num *= i;
        }
        return num;
    }
}
