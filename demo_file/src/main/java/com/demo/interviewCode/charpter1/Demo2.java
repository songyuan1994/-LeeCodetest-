package com.demo.interviewCode.charpter1;

import java.util.Stack;

/**
 * 题目描述：
 * 一个栈依次压入1、2、3、4、5，那么从栈顶到栈底分别为5、4、3、2、1。
 * 将这个栈转置后，从栈顶到栈底为1、2、3、4、5，也就是实现栈中元素的逆序。
 * 但是只能用递归函数实现，不能用其他数据结构
 *
 * @author sy
 */
public class Demo2 {
    //用递归的方法，一直取值，知道最后一个，然后放入栈中。


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("**********: " + getAndRemove(stack));

    }

    public static int getAndRemove(Stack<Integer> stack) {
        int result = stack.pop();
        System.out.println("result=" + result);
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemove(stack);
            System.out.println("last=" + last);
            return last;
        }
    }
}
