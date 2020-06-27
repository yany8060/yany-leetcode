package com.yany.swordoffer;

import com.yany.model.TreeNode;

public class _55_TreeDepth {

    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        return Math.max(left + 1, right + 1);
    }


    private boolean isBalanced = false;//最后的返回值

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }

        return isBalanced;
    }

    public int isBalancedDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = isBalancedDepth(root.left);
        int right = isBalancedDepth(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        } else {
            isBalanced = true;
        }

        return Math.max(left, right) + 1;
    }

}
