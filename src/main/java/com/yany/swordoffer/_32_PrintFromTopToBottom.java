package com.yany.swordoffer;


import com.yany.leetcode.model.TreeNode;

import java.util.*;

public class _32_PrintFromTopToBottom {

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


        System.out.println(new _32_PrintFromTopToBottom().PrintFromTopToBottom(root));
    }


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list;
    }
}
