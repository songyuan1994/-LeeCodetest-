package com.labuladuoGuide.leeCode.treeCollection;

import java.time.*;
import java.util.Date;

/**
 * @author Thin'k'pa'd
 * LeetCode 226翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 */
public class Demo1 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(7);
        treeNode.left = leftNode;
        //treeNode.right = rightNode;

        TreeNode leftNode1 = new TreeNode(1);
        TreeNode rightNode1 = new TreeNode(3);
        leftNode.left = leftNode1;
        leftNode.right = rightNode1;

        TreeNode leftNode2 = new TreeNode(6);
        TreeNode rightNode2 = new TreeNode(9);
        rightNode.left = leftNode2;
        rightNode.right = rightNode2;

        //TreeNode.middlePrintTree(treeNode);
        //TreeNode.firstPrintTree(treeNode);
        TreeNode.lastPrintTree(treeNode);

        //treeNode = invertTree(treeNode);
        //System.out.println("after invert");
        //TreeNode.printTree(treeNode);


    }

    public static TreeNode invertTree(TreeNode root) {
        if (root.left == null || root.right == null) {
            root = exchangeNode(root);
            root.left = invertTree(root.left);
            root.right = invertTree(root.right);
        }
        return root;
    }

    public static TreeNode exchangeNode(TreeNode root){
        TreeNode tempNode = new TreeNode(root.val);
        tempNode.right = root.left;
        tempNode.left = root.right;
        return tempNode;
    }
}
