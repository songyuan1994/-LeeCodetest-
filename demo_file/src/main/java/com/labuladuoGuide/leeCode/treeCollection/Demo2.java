package com.labuladuoGuide.leeCode.treeCollection;

import java.util.*;

/**
 * leetCode 114 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 * 例如，给定二叉树
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：

 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class Demo2 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(5);
        treeNode.left = leftNode;
        treeNode.right = rightNode;

        TreeNode leftNode1 = new TreeNode(3);
        TreeNode rightNode1 = new TreeNode(4);
        leftNode.left = leftNode1;
        leftNode.right = rightNode1;

        //TreeNode leftNode2 = new TreeNode(6);
        TreeNode rightNode2 = new TreeNode(6);
        //rightNode.left = leftNode2;
        rightNode.right = rightNode2;

        //TreeNode.firstPrintTree(treeNode);

        //flatten(null);
        TreeNode.firstPrintTreeByStack(treeNode);
    }

    public static void flatten(TreeNode root) {
        Deque test = new LinkedList();
        List<TreeNode> nodeList = new ArrayList<>();
        preOrder(root,nodeList);
        for(int i=1;i<nodeList.size();i++){
            TreeNode prev = nodeList.get(i - 1), curr = nodeList.get(i);
            prev.left = null;
            prev.right = curr;
        }

    }

    public static void preOrder(TreeNode node, List<TreeNode> list){
        if(node != null){
            list.add(node);
            preOrder(node.left,list);
            preOrder(node.right,list);
        }
    }

    /**
     * 通过迭代实现的遍历
     * @param root
     */
    public void flatten2(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    /**
     * 寻找前驱节点法，节省了空间，空间复杂度为O(1)
     * @param root
     */
    public void flatten3(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }


}
