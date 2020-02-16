package com.yany.leetcode;

import com.yany.leetcode.model.TreeNode;

/**
 * @author yanyong on 2020/2/11
 */
public class _98_ValidateBinarySearchTree {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);

        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(8);

        root.left = r1;
        root.right = r2;


        TreeNode r3 = new TreeNode(6);
        TreeNode r4 = new TreeNode(9);

        r2.left = r3;
        r2.right = r4;


        System.out.println(new _98_ValidateBinarySearchTree().isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.val < root.left.val) {
            return false;
        }
        if (root.right != null && root.val > root.right.val) {
            return false;
        }

        if (!isValidBST(root.left)) {
            return false;
        }
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }


}
