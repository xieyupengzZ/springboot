package com.xieyupeng.springboot.Utils;

/**
 * Created by XYP on 2018/4/8.
 * 二叉查找树
 */
public class BinaryTree {

    private int num = 0;
    //根节点
    private Node mainNode = null;
    //存放数组节点
    private int[] nodes = null;
    private int nodesindex = 0;

    public BinaryTree(int data){
        Node firstNode = new Node(data,null,null,"mainNode");
        this.mainNode = firstNode;
    }

    public static class Node{

        //访问标示
        boolean isTraversal = false;
        String detail = "";
        int data = 0;
        Node lNode = null;
        Node rNode = null;
        Node pNode = null;

        public Node(int data,Node lNode,Node rNode,String detail){
            this.data = data;
            this.lNode = lNode;
            this.rNode = rNode;
            this.detail = detail;
        }

        public void setParentNode(Node pNode){
            this.pNode = pNode;
        }
    }

    //TODO 递归的时候，return是返回给上一级调用，不是结束。
    //TODO 高度是从叶子往上，叶子算1。
    //TODO 对于整棵树来说高度和深度一样，但是对于中间节点不同
    public int getNodeHeight(Node node) {

        if(node==null){
            return 0;
        }
        Node leftNode = node.lNode;
        Node rightNode = node.rNode;

        int leftHeight = 0;
        int rightHeight = 0;
        if(leftNode!=null){
            System.out.println("遍历到了 "+ node.detail + " 它的左孩子是 "+ leftNode.detail);
            leftHeight = getNodeHeight(leftNode);
        }
        if(rightNode!=null){
            System.out.println("遍历到了 "+ node.detail + " 它的右孩子是 "+rightNode.detail);
            rightHeight = getNodeHeight(rightNode);
        }
        System.out.println("遍历到了 "+ node.detail + " 左子树高度 "+leftHeight + " 右字树高度 "+rightHeight);
        return leftHeight>rightHeight?++leftHeight:++rightHeight;
    }

    //TODO 深度是从根节点往下，根节点算1
    public int getNodeDepth(Node node){
        if(node==null){
            return 0;
        }
        Node parentNode = node.pNode;
        int depth = 0;
        if(parentNode!=null){
            System.out.println("遍历到了 "+ node.detail + " 它的父节点是 "+ parentNode.detail);
            depth = getNodeDepth(parentNode);
        }
        System.out.println("遍历到了 "+ node.detail + " 它的深度是 "+(depth+1));
        return ++depth;
    }

    //节点遍历标识
    private void setNodeTraversal(Node node){
        if(!node.isTraversal){
            node.isTraversal = true;
            this.nodes[nodesindex] = node.data;
            nodesindex++;
        }
    }

    /**
     * 前序遍历
     */
    public void preTraversal(Node node) {
        if(node!=null){
            System.out.println("遍历到了 "+node.detail);
            setNodeTraversal(node);
            preTraversal(node.lNode);
            preTraversal(node.rNode);
        }
    }

    /**
     * 中序遍历
     */
    public void inoTraversal(Node node) {
        if(node!=null){
            if(node.lNode!=null){
                inoTraversal(node.lNode);
                setNodeTraversal(node);
            }else {
                System.out.println("遍历到了 "+node.detail);
                setNodeTraversal(node);
            }
            if(node.rNode!=null){
                inoTraversal(node.rNode);
            }else {
                System.out.println("遍历到了 "+node.detail);
                setNodeTraversal(node);
            }
        }
        return;
    }

    /**
     * 后序遍历
     */
    public void posTraversal() {

    }

    /**
     * 层次遍历
     */
    public void cengTraversal() {

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

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(100);
        Node node10 = new Node(1,null,null,"node10");
        Node node9 = new Node(2,null,null,"node9");
        Node node8 = new Node(3,node10,null,"node8");
        Node node7 = new Node(4,null,null,"node7");
        Node node6 = new Node(5,null,node9,"node6");
        Node node5 = new Node(6,node7,node8,"node5");
        Node node4 = new Node(7,null,null,"node4");
        Node node3 = new Node(8,null,node6,"node3");
        Node node2 = new Node(9,node4,node5,"node2");
        tree.mainNode.lNode = node2;
        tree.mainNode.rNode = node3;
        node2.setParentNode(tree.mainNode);
        node3.setParentNode(tree.mainNode);
        node4.setParentNode(node2);
        node5.setParentNode(node2);
        node6.setParentNode(node3);
        node7.setParentNode(node5);
        node8.setParentNode(node5);
        node9.setParentNode(node6);
        node10.setParentNode(node8);

//        System.out.println(tree.getNodeDepth(node10));
//        System.out.println(tree.getNodeHeight(node3));

        tree.nodes = new int[10];
//        tree.preTraversal(tree.mainNode);
        tree.inoTraversal(tree.mainNode);
        for (int node : tree.nodes) {
            System.out.print(node + " ");
        }
    }
}
