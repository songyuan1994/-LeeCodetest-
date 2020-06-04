package testLeetCode;
/*
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
        示例 1:
        输入: 121
        输出: true
        示例 2:
        输入: -121
        输出: false
        解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
        示例 3:
        输入: 10
        输出: false
        解释: 从右向左读, 为 01 。因此它不是一个回文数。
        进阶:
        你能不将整数转为字符串来解决这个问题吗？
*/


public class Test4 {
    public static void main(String args[]){
        //hhhasdad
        System.out.println("result :"+revert(10));

    }

    // 通过/10 %10 来进行数字的反转，但是会存在反转后int大小溢出的问题，需要考虑
    public static Boolean revert(int number){
        int result = number;
        int rex = 0;
        if(number==0){
            return true;
        }
        while(number > 0){
            int pop = number%10;
            number = number/10;
            rex = rex*10+pop;
        }
        return rex==result;
    }

    class Solution {
        public boolean isPalindrome(int x) {

            if(x<10&&x>=0)return true;

            char[] chars = String.valueOf(x).toCharArray();

            int left=0;
            int right=chars.length-1;

            while (left<right){

                if(chars[left]==chars[right]){
                    left++;
                    right--;
                }else return false;

            }
            return true;

        }
    }
}
