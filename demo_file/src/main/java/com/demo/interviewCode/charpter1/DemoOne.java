package com.demo.interviewCode.charpter1;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 设计一个有GetMin功能的栈
 * 题目：
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * @author sy
 */
public class DemoOne {
    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        stack.push("one");
        System.out.println("peek: "+stack.peek());
        stack.push("two");
        System.out.println("peek: "+stack.peek());

        System.out.println("");

        TestStack<String> testStack = new TestStack();
        testStack.push(1);
        System.out.println("test peek: "+testStack.peek());
        testStack.push(2);
        System.out.println("test peek: "+testStack.peek());

    }


    static class TestStack<E>{
        protected Object[] elementData;

        protected Stack<Integer> minValueStack = new Stack<>();

        protected int modCount = 0;

        public TestStack() {
            this.elementData = new Object[10];
        }

        public void push(int element){
            elementData[modCount++] = element;
            if(minValueStack.isEmpty()){
                minValueStack.push(java.lang.Integer.valueOf(element));
            }else if(element <= (int)minValueStack.peek()) {
                minValueStack.push(element);
            }
        }

        public synchronized Object pop(){
            Object obj;
            int     len = modCount;

            obj = elementData[modCount-1];
            removeElementAt(len - 1);
            return obj;
        }

        private void removeElementAt(int index) {
            int j = modCount - index - 1;
            if (j > 0) {
                System.arraycopy(elementData, index + 1, elementData, index, j);
            }
            modCount--;
            elementData[modCount] = null; /* to let gc do its work */
        }

        public synchronized Integer peek() {
            int  len = modCount;

            if (len == 0) {
                throw new EmptyStackException();
            }
            return (Integer)elementData[modCount-1];
        }
    }
}
