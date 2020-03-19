package com.yany.swordoffer;

import com.yany.leetcode.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yanyong on 2020/2/23
 */
public class ReConstructBinaryTree {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        Map<Integer, Integer> indexForInOrders = new HashMap<>();

        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }

        return reConstructBinaryTree(pre, 0, in.length - 1, 0, indexForInOrders);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL, Map<Integer, Integer> indexForInOrders) {
        if (preR > preL) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preL]);
        int index = indexForInOrders.get(pre[preL]);
        int numL = index - inL;//左子树节点个数preL + 1
        root.left = reConstructBinaryTree(pre, preL + 1, preL + numL, inL, indexForInOrders);
        root.right = reConstructBinaryTree(pre, preL + numL + 1, preR, inL + numL + 1, indexForInOrders);
        return root;
    }
}
