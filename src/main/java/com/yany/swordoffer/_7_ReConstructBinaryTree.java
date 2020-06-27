package com.yany.swordoffer;

import com.yany.model.TreeNode;

/**
 * @author yanyong on 2020/3/23
 */
public class _7_ReConstructBinaryTree {

    public static void main(String[] args) {

    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {


        return null;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in, int rootNum) {
        TreeNode root = new TreeNode(pre[rootNum]);
        int rootInNum = -1;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[rootNum]) {
                rootInNum = i;
                break;
            }
        }

        root.left = reConstructBinaryTree(pre, in, rootNum + 1);
        root.right = reConstructBinaryTree(pre, in, in.length - rootInNum - 1);
        return root;
    }

}
