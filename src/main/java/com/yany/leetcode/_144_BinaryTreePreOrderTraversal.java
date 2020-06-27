package com.yany.leetcode;

import com.yany.model.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144_BinaryTreePreOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        new _144_BinaryTreePreOrderTraversal().preOrderTraversal(root);
    }




    public List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        preOrderNoRe(root, list);
        return list;
    }


    private void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    private void preOrderNoRe(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);

            }
        }
    }


}
