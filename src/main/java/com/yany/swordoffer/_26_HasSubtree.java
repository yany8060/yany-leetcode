package com.yany.swordoffer;

import com.yany.model.TreeNode;

/**
 * 树的子结构
 *
 * @author yanyong on 2020/3/26
 */
public class _26_HasSubtree {


    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = isSubTree(root1, root2);
            }
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }

        return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
    }


}
