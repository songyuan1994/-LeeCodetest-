package com.labuladuoGuide.leeCode.treeCollection;

import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     *   输入：
     *
     *        4
     *      /   \
     *     2     7
     *    / \   / \
     *   1   3 6   9
     */


    /**
     * 中序遍历树，左-根-右
     *
     * @param node
     */
    public static void middlePrintTree(TreeNode node) {
        if (node != null) {
            middlePrintTree(node.left);
            System.out.println(node.val);
            middlePrintTree(node.right);
        }
    }

    /**
     * 前根序遍历 根-左-右
     *
     * @param node
     */
    public static void firstPrintTree(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            firstPrintTree(node.left);
            firstPrintTree(node.right);
        }
    }

    /**
     * 通过迭代实现
     * 前根序遍历 根-左-右
     *
     * @param node node
     */
    public static void firstPrintTreeByStack(TreeNode node) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (node != null || !stack.isEmpty()) {
            while(node != null){
                System.out.println(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
    }

    /**
     * 后根序遍历 左-右-根
     *
     * @param node
     */
    public static void lastPrintTree(TreeNode node) {
        if (node != null) {
            lastPrintTree(node.left);
            lastPrintTree(node.right);
            System.out.println(node.val);
        }
    }


}
