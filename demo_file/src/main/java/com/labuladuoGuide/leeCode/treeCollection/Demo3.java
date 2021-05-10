package com.labuladuoGuide.leeCode.treeCollection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 116题 填充每个节点的下一个右侧节点指针
 * <p>
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */
public class Demo3 {
    public static void main(String[] args) {
        //按层来输出二叉树，要按层来输出。
        //
        Node treeNode = new Node(1);
        Node leftNode = new Node(2);
        Node rightNode = new Node(3);
        treeNode.left = leftNode;
        treeNode.right = rightNode;

        Node leftNode1 = new Node(4);
        Node rightNode1 = new Node(5);
        leftNode.left = leftNode1;
        leftNode.right = rightNode1;

        Node leftNode2 = new Node(6);
        Node rightNode2 = new Node(7);
        rightNode.left = leftNode2;
        rightNode.right = rightNode2;
        connect(treeNode);
    }

    /**
     * 通过栈的形式,层次遍历
     */
    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                assert node != null;
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    /**
     * 这种是通过next来遍历的，即在第N-1层，设置第N层的next信息
     * 会有两种情况，next为head的右节点， next为head.next的左节点。
     *
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }
        // 从根节点开始
        Node leftmost = root;
        while (leftmost.left != null) {
            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = leftmost;
            while (head != null) {
                // CONNECTION 1
                head.left.next = head.right;
                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                // 指针向后移动
                head = head.next;
            }
            // 去下一层的最左的节点
            leftmost = leftmost.left;
        }
        return root;
    }

}
