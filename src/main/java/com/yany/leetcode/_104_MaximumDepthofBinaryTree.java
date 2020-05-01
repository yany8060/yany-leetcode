package com.yany.leetcode;

import com.yany.leetcode.model.TreeNode;

/**
 * @author yanyong on 2020/5/1
 */
public class _104_MaximumDepthofBinaryTree {


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
    }
}
