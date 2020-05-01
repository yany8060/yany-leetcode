package com.yany.model;

/**
 * @author yanyong on 2019/3/6
 */
public class BTree {

    private Node root;

    public BTree(Node root) {
        this.root = root;
    }

    public void add(int v) {
        if (root == null) {
            root = new Node(v);
        }
        add(root, new Node(v));
    }

    public void add(Node node, Node i) {
        if (node.data == i.data) {
            return;
        }
        if (node.data > i.data) {
            if (node.leftChild == null) {
                node.leftChild = i;
                return;
            }
            add(node.leftChild, i);
        }
        if (node.data < i.data) {
            if (node.rightChild == null) {
                node.rightChild = i;
                return;
            }
            add(node.rightChild, i);
        }
    }

    public Node search(int v) {
        return search(root, new Node(v));
    }

    private Node search(Node node, Node s) {
        if (node.data == s.data) {
            return s;
        }
        if (node.data > s.data) {
            search(node.leftChild, s);
        }
        if (node.data < s.data) {
            search(node.rightChild, s);
        }
        return null;
    }


    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    class Node {
        private int data;
        private Node leftChild = null;
        private Node rightChild = null;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }


        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        public Node getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }
    }
}
