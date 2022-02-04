package com.yany.swordoffer.nk;

import com.yany.model.TreeLinkNode;

public class JZ8 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }


        // 左子树
        if (pNode.next != null && pNode == pNode.next.left) {
            return pNode.next;
        }

        // 右子树
        while (pNode.next != null) {
            TreeLinkNode p = pNode.next;
            if (p.next != null && p.next.left == p) {
                return p.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}
