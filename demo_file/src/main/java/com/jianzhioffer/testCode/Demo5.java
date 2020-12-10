package com.jianzhioffer.testCode;

import java.util.*;

/**
 * 剑指 Offer 07. 重建二叉树
 * 题目链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * 描述：
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 *  3
 * / \
 * 9  20
 *   /  \
 *  15   7
 */
public class Demo5 {
    public static Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        //前序遍历： 从根结点-左节点-右节点
        //中序遍历： 从左节点-根节点-右节点
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode node = buildTree(preorder, inorder);
        while (node != null) {
            System.out.println(node.val);
            node = node.right;
        }
    }

/*    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode head = new TreeNode(preorder[0]);


        return null;
    }*/

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
        return root;
    }

    /**
     * 通过中序能确定根节点，左边的即为它的左节点，右边的即为它的右节点
     * @param preorder
     * @param preorderStart
     * @param preorderEnd
     * @param inorder
     * @param inorderStart
     * @param inorderEnd
     * @param indexMap
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        if (preorderStart == preorderEnd) {
            return root;
        } else {
            int rootIndex = indexMap.get(rootVal);
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }
    }

    public TreeNode buildTree2(int[] preorder,int[] inorder){
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int length = preorder.length;
        for(int i=0;i<length;i++){
            indexMap.put(inorder[i],i);
        }
        TreeNode head = buildTree2(preorder,0,length-1,0,length-1);
        return head;
    }

    public TreeNode buildTree2(int[] preOrder,int preOrderStart,int preOrderEnd,int inOrderStart,int inOrderEnd){
        if(preOrderStart>preOrderEnd){
            return null;
        }
        int rootVal = preOrder[preOrderStart];
        TreeNode root = new TreeNode(rootVal);
        if(preOrderStart == preOrderEnd){
            return root;
        }else {
            int rootindex = indexMap.get(rootVal);
            int leftNodeIndex = rootindex - inOrderStart;
            int rightNodeIndex = inOrderEnd - rootindex;
            TreeNode leftNode = buildTree2(preOrder,preOrderStart+1,preOrderStart+leftNodeIndex,inOrderStart,rootindex-1);
            TreeNode rightNode = buildTree2(preOrder,preOrderEnd -rightNodeIndex +1,preOrderEnd,rootindex+1,inOrderEnd);
            root.left = leftNode;
            root.right = rightNode;
            return root;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

