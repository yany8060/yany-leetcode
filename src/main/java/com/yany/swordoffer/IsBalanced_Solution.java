package com.yany.swordoffer;

import com.yany.model.TreeNode;

/**
 * @author yanyong on 2020/2/24
 */
public class IsBalanced_Solution {
    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int rh = height(root.right) + 1;
        int lh = height(root.left) + 1;
        if (isBalanced && Math.abs(lh - rh) > 1) {
            isBalanced = false;
        }
        return Math.max(rh, lh);
    }
}
