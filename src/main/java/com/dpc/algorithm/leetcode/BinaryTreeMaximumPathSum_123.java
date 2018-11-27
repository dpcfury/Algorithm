package com.dpc.algorithm.leetcode;

import com.dpc.algorithm.leetcode.datastructure.TreeNode;

/**
 * Given a non-empty binary tree, find the maximum path sum.
 * <p>
 * For this problem, a path is defined as any sequence of nodes from some starting node
 * to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 */
public class BinaryTreeMaximumPathSum_123 {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        travesal(root);
        return max;
    }

    private int travesal(TreeNode node) {
        if (node == null) return 0;
        int left = travesal(node.left);
        int right = travesal(node.right);

        int bigger = Math.max(left, right);
        int result = node.val + (bigger > 0 ? bigger : 0);
        if (result > max) max = result;
        int valWithChild = node.val + left + right;
        if (valWithChild > max) max = valWithChild;

        return result;
    }
}
