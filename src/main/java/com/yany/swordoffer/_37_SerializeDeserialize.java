package com.yany.swordoffer;

import com.yany.model.TreeNode;

public class _37_SerializeDeserialize {
    public static void main(String[] args) {
        new _37_SerializeDeserialize().Deserialize("1,2,4,$,$,$,3,5,$,$,6,$,$");
    }

    public String Serialize(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return "$,";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(pRootOfTree.val + ",");
        sb.append(Serialize(pRootOfTree.left));
        sb.append(Serialize(pRootOfTree.right));

        return sb.toString();
    }

    public TreeNode Deserialize(String str) {
        /*String[] s = str.split(",");
        String tmp = s[0];
        str = str.substring(str.indexOf(",") + 1);
        if (tmp.equals("$")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        root.left = Deserialize(str);
        root.right = Deserialize(str);*/
        return Deserialize(new StringBuilder(str));
    }

    public TreeNode Deserialize(StringBuilder str) {
        String[] s = str.toString().split(",");
        String tmp = s[0];
        str.delete(0, str.indexOf(",") + 1);
        if (tmp.equals("$")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        root.left = Deserialize(str);
        root.right = Deserialize(str);
        return root;
    }


}
