package com.yany.swordoffer;

import com.yany.model.TreeNode;

import java.util.ArrayList;

public class _34_FindPath {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);

        TreeNode r1 = new TreeNode(5);
        TreeNode r2 = new TreeNode(12);
        root.left = r1;
        root.right = r2;


        TreeNode r3 = new TreeNode(4);
        TreeNode r4 = new TreeNode(7);
        r1.left = r3;
        r1.right = r4;


        System.out.println(new _34_FindPath().FindPath(root, 22));
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        FindPath(root, target, 0, new ArrayList<>(), lists);
        return lists;
    }

    public void FindPath(TreeNode root, int target, int currentSum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> lists) {
        currentSum += root.val;
        path.add(root.val);

        if (currentSum == target && root.right == null && root.left == null) {
            lists.add(new ArrayList<>(path));
            return;
        }
        if (root.left != null) {
            FindPath(root.left, target, currentSum, path, lists);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {
            FindPath(root.right, target, currentSum, path, lists);
            path.remove(path.size() - 1);
        }

    }

}
