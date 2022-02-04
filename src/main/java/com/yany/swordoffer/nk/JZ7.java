package com.yany.swordoffer.nk;

import com.yany.model.TreeNode;

import java.util.Arrays;

public class JZ7 {
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] vin = {4, 7, 2, 1, 5, 3, 8, 6};

        new JZ7().reConstructBinaryTree2(pre, vin);

    }


    /**
     * 描述
     * 给定节点数为 n 的二叉树的前序遍历和中序遍历结果，请重建出该二叉树并返回它的头结点。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建出如下图所示。
     *
     * @param pre
     * @param vin
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        if (pre.length == 0) {
            return null;
        }

        if (pre.length == 1) {
            return new TreeNode(pre[0]);
        }

        int r = pre[0];
        TreeNode root = new TreeNode(r);

        int i = 0;
        while (r != vin[i]) {
            i++;
        }

        if (i < pre.length - 1) {
            int[] rpre = Arrays.copyOfRange(pre, i + 1, pre.length);
            int[] rvin = Arrays.copyOfRange(vin, i + 1, vin.length);
            root.right = reConstructBinaryTree(rpre, rvin);
        }
        if (i > 0) {
            int[] lpre = Arrays.copyOfRange(pre, 1, i + 1);
            int[] lvin = Arrays.copyOfRange(vin, 0, i);
            root.left = reConstructBinaryTree(lpre, lvin);
        }
        return root;
    }


    public TreeNode reConstructBinaryTree2(int[] pre, int[] vin) {
        if (pre.length == 0 || vin.length == 0) {
            return null;
        }
        return constructTree(pre, 0, pre.length - 1, vin, 0, vin.length - 1);
    }

    public TreeNode constructTree(int[] pre, int pl, int pr, int[] vin, int vl, int vr) {
        if (pl == pr) {
            return new TreeNode(pre[pl]);
        }

        TreeNode root = new TreeNode(pre[pl]);
        int i = vl;
        while (pre[pl] != vin[i]) {
            i++;
        }
        int llength = i - vl;
        int rlength = vr - i;

        if (llength > 0) {
            root.left = constructTree(pre, pl + 1, pl + llength, vin, vl, vl + llength - 1);
        }

        if (rlength > 0) {
            root.right = constructTree(pre, pr - rlength + 1, pr, vin, vr - rlength + 1, vr);
        }
        return root;
    }
}
