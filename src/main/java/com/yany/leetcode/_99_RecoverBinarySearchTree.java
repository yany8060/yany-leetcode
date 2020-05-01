package com.yany.leetcode;

import com.yany.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanyong on 2020/4/1
 */
public class _99_RecoverBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode r1 = new TreeNode(3);
        TreeNode r2 = new TreeNode(2);
        root.left = r1;

        r1.right = r2;

        new _99_RecoverBinarySearchTree().recoverTree(root);

    }


    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        List<Integer> list = new ArrayList<>();
        preTree(root, list);



    }

    public void preTree(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
            return;
        }

        list.add(root.val);
        preTree(root.left, list);
        preTree(root.right, list);
    }

}
