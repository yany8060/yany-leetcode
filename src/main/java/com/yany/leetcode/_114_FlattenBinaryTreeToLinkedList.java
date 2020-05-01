package com.yany.leetcode;

import com.yany.model.TreeNode;

import java.util.Stack;

/**
 * 给定一个二叉树，原地将它展开为链表。
 *
 * @author yanyong on 2020/5/1
 */
public class _114_FlattenBinaryTreeToLinkedList {


    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode index = root;
        if (index.right != null) {
            stack.push(index.right);
        }
        if (index.left != null) {
            stack.push(index.left);
        }

        while (!stack.empty()) {
            TreeNode node = stack.pop();

            index.left = null;
            index.right = node;
            index = index.right;

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
