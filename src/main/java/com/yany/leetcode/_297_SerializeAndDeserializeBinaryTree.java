package com.yany.leetcode;

import com.yany.leetcode.model.TreeNode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @author yanyong on 2019/6/10
 */
public class _297_SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(serialize(root));
        root = deserialize("1 2 # # 3 # # ");
        System.out.println("");
    }


    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuffer s = new StringBuffer();
        serialize(root, s);
        return s.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] d = data.split(" ");
        Stack<String> s = new Stack<>();
        for (int i = d.length - 1; i >= 0; i--) {
            s.push(d[i]);
        }
        return deserialize(s);
    }


    public static TreeNode deserialize(Stack<String> d) {
        String s = d.pop();
        if (d.size() == 0 || s.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = deserialize(d);
        root.right = deserialize(d);
        return root;
    }

    public static void serialize(TreeNode root, StringBuffer s) {
        if (root == null) {
            s.append("# ");
            return;
        }
        s.append(root.val + " ");
        serialize(root.left, s);
        serialize(root.right, s);
    }

}
