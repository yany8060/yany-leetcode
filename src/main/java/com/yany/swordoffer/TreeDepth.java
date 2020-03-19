package com.yany.swordoffer;

import com.yany.leetcode.model.TreeNode;

/**
 * @author yanyong on 2020/2/24
 */
public class TreeDepth {

    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }
}
