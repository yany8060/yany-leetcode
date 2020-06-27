package com.yany.leetcode;

import com.yany.model.TreeNode;

/**
 * @author yanyong on 2019/7/8
 */
public class _100_SameTree {


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;

        if (p == null || q == null)
            return false;

        if (p.val != q.val)
            return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


}
