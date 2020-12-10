package com.jianzhioffer.testCode;

/**
 * 剑指offer 4.二维数组中的查找
 * 题目连接:https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * 描述：
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Demo2 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}
                , {2, 5, 8, 12, 19}
                , {3, 6, 9, 16, 22}
                , {10, 13, 14, 17, 24}
                , {18, 21, 23, 26, 30}};
        int [][] ss = new int[][]{{}};
        findNumberIn2DArray(ss, 0);

    }


    /**
     * 自己写的，思路是从左上角开始比较，如果target大于，则往右走继续查找，如果小于，则跳出循环
     * 问题，从左上角查，向下，向右都是递增的，导致你需要一个个循环去找，效率会比较低。
     * 改进：从右上角查，向下递增，向左递减。这样当target大于小于的时候，都比较好处理。
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0|| matrix[0].length == 0 || target < matrix[0][0])
            return false;
        for (int i = 0; i < matrix.length; i++) {
            if (target > matrix[i][0]) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (target == matrix[i][j]) {
                        System.out.println("i = " + i + " j = " + j);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 改进版：
     * 从右上角查找。
     * 另外：也可以从左下角查找，因为往右是递增，往上是递减
     * 这样做的好处是，一旦target比flag大，那么flag所在的行被消去了，往下查找。
     * 一旦target比flag小，那么flag所在的列被消去了，往左查找。
     * 所以每轮对比时，都会消去一列或者行元素，以降低时间复杂度。
     * 所以效率会高很多。
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

}
