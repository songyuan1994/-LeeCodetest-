package com.demo.interviewCode.charpter1;

import java.util.Stack;

/**
 * Demo1的官方解法
 *
 * @author sy
 */
public class MyStack1 {
    private Stack<Integer> stackData;

    private Stack<Integer> stackMin;

    public MyStack1() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int newNumber) {
        stackData.push(newNumber);
        if (stackMin.isEmpty() || newNumber <= stackMin.peek()) {
            stackMin.push(newNumber);
        }
    }

    public int getMinimum() {
        if (stackData.isEmpty() || stackMin.isEmpty()) {
            throw new RuntimeException("stack is empty!");
        }
        return stackMin.peek();
    }

    public int pop() {
        if (stackData.isEmpty() || stackMin.isEmpty()) {
            throw new RuntimeException("stack is empty!");
        }
        int num = stackData.pop();
        if (num == stackMin.peek()) {
            stackMin.pop();
        }
        return num;
    }

    public int peek() {
        if (stackData.isEmpty() || stackMin.isEmpty()) {
            throw new RuntimeException("stack is empty!");
        }
        return stackData.peek();
    }

    public static void main(String[] args) {
        MyStack1 stack1 = new MyStack1();
        stack1.push(2);
        System.out.println("min: " + stack1.getMinimum());
        stack1.push(1);
        System.out.println("min: " + stack1.getMinimum());
        stack1.pop();
        System.out.println("min: " + stack1.getMinimum());
    }
}
