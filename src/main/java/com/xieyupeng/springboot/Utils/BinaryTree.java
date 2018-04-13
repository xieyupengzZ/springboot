package com.xieyupeng.springboot.Utils;

/**
 * Created by XYP on 2018/4/8.
 * 二叉查找树
 */
public class BinaryTree {

    private int num = 0;
    private Node mainNode = null;

    public BinaryTree(int data){
        Node firstNode = new Node(data,null,null,null);
        mainNode = firstNode;
    }

    public static class Node{

        int data;
        Node lNode;
        Node rNode;
        Node pNode;

        public Node(int data,Node lNode,Node rNode,Node pNode){
            data = data;
            lNode = lNode;
            rNode = rNode;
            pNode = pNode;
        }
    }

    public int size(){
        return num;
    }

    public void getHeight() {

    }

    public void insert(int data) {

    }

    public void delete(int data) {

    }

    /**
     * 前序遍历
     */
    public void preTraversal() {

    }

    /**
     * 中序遍历
     */
    public void inoTraversal() {

    }

    /**
     * 后序遍历
     */
    public void posTraversal() {

    }

    /**
     * 该数最大节点
     */
    public void maxNode() {

    }

    /**
     * 该数最小节点
     */
    public void minNode() {

    }

    /**
     * 前驱
     * 该节点左子树最大的节点
     */
    public void precursor(Node node) {

    }

    /**
     * 后继
     * 该节点右子树最小的节点
     */
    public void successor(Node node) {

    }

}
