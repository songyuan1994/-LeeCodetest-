package com.labuladuoGuide.leeCode.treeCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * leeCode 654题目 最大二叉树
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * <p>
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * <p>
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 * <p>
 *    6
 * /   \
 * 3     5
 * \    /
 * 2  0
 * \
 * 1
 *
 * @author songyuan
 */
public class Demo4 {
    public static void main(String[] args) {
        //[3,2,1,6,0,5]
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        int max = nums[0];
        int index = 1;
        List<Integer> leftList = new ArrayList<>();
        while (index < nums.length){
            if(nums[index]>max){

            }
        }

    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }


    public static TreeNode construct(int[] nums, int l ,int r){
        if(l == r){
            return null;
        }
        int maxIndex = getMaxIndex(nums, l, r);
        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = construct(nums,l ,maxIndex);
        //因为最开始的r是length，所以maxIndex+1最大也就是R了
        node.right = construct(nums,maxIndex+1,r);
        return node;
    }

    public static int getMaxIndex(int[] nums,int start, int end) {
        int maxIndex = start;
        for (int i = start; i < end; i++) {
            if(nums[i]>nums[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
