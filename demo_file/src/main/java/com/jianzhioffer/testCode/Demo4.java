package com.jianzhioffer.testCode;

/**
 * 剑指Offer 6 从头到尾打印链表
 * 连接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class Demo4 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        System.out.println("This is a test!!");
        System.out.println("This is a testb!!");
        int[] result = reversePrint(head);
        for(int value : result){
            System.out.println(value);
        }
    }

    public static int[] reversePrint(ListNode head) {
        int length = 0;
        ListNode node = head;
        while(node != null){
            length++;
            node = node.next;
        }
        node = head;
        int[] result = new int[length];
        while (node !=null){
            result[length -1] = node.val;
            length--;
            node = node.next;
        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
