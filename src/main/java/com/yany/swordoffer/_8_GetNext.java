package com.yany.swordoffer;

import com.yany.model.TreeNode;

public class _8_GetNext {


    public TreeNode getNext(TreeNode pNode) {
        if (pNode == null) {
            return null;
        }

        TreeNode pNext;
        if (pNode.right != null) {
            TreeNode rNode = pNode.right;
            while (rNode != null) {
                rNode = rNode.left;
            }
            pNext = rNode;
        }

        return null;

    }

}
