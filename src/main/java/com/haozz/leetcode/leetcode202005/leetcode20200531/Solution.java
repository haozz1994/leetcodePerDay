package com.haozz.leetcode.leetcode202005.leetcode20200531;

/**
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 * <p>
 * leetcode:671.二叉树中第二小的节点
 * <p>
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
 * <p>
 * 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 2   5
 * / \
 * 5   7
 * <p>
 * 输出: 5
 * 说明: 最小的值是 2 ，第二小的值是 5 。
 * 示例 2:
 * <p>
 * 输入:
 * 2
 * / \
 * 2   2
 * <p>
 * 输出: -1
 * 说明: 最小的值是 2, 但是不存在第二小的值。
 */
public class Solution {


    /**
     * 1.第二小的数字：定义两个变量存放第一小和第二小的数字;
     * 2.定义count计数器,如果二叉树只有一个数字的话,意味着second没有被赋值,那么count等于0,输出-1;如果count 大于0 那么就输出second;
     */

    int min = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;
    int count = 0;

    public int findSecondMinimumValue(TreeNode root) {
        helper(root);
        return count == 0 ? -1 : secondMin;
    }

    public void helper(TreeNode treeNode) {

        if (treeNode == null) {
            return;
        }

        if (treeNode.val < min) {
            secondMin = min;
            min = treeNode.val;
        } else if (treeNode.val > min && treeNode.val <= secondMin) {
            count++;
            secondMin = treeNode.val;
        }

        helper(treeNode.left);
        helper(treeNode.right);
    }


//    int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
//    int count = 0;
//
//    public int findSecondMinimumValue(TreeNode root) {
//        helper(root);
//        return count == 0 ? -1 : second;
//    }
//
//    public void helper(TreeNode root) {
//        if (root == null)
//            return;
//
//        if (root.val < first) {
//            second = first;
//            first = root.val;
//        } else if (root.val <= second && root.val > first) {
//            count++;
//            second = root.val;
//        }
//        helper(root.left);
//        helper(root.right);
//    }


}
