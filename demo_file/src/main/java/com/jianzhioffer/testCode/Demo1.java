package com.jianzhioffer.testCode;

import java.util.Arrays;

/**
 * 数组中重复的数字
 * 牛客网
 * 连接：https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
 * <p>
 * 题目描述：
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class Demo1 {
    public static void main(String[] args) {
        int[] numbers = {2, 1, 3, 3, 4};
        int[] result = new int[10];
        findDuplicateNum(numbers, 5, result);
        System.out.println("result : " + result[0]);
    }

    public static boolean findDuplicateNum(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        //判断后一个是否等于前一个，因为已经排序过了
/*        for (int i = 0; i < length - 1; i++) {
            if(numbers[i] == numbers[i+1]){
                duplication[0] = numbers[i];
                return true;
            }
        }*/

        //这个是通过判断每个位置上是否是对应的数来保证的，比如数字0就应该在数组0位置。
        //但会存在，当所给数组不是从0开始的，就查找不对的问题，比如{1，2,2,3}这样的
        for (int i = 0; i < length; i++) {
            if (numbers[i] != i) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}
