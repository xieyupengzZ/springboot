package com.xieyupeng.springboot.studys.DataStructure;

/**
 * Created by XYP on 2018/3/26.
 * 通过java构造双向链表（一般是双向循环链表）
 */
public class TwowayLinkedList<T> {

    private Node<T> head; //表头不算一个节点

    private int count;

    private class Node<T>{

        private Node pre;

        private Node next;

        private T val;

        public Node(Node pre,Node next,T val){
            this.pre = pre;
            this.next = next;
            this.val = val;
        }

    }

    //一直指向自己，就是一个节点，表头不算节点，所以长度为0
    public TwowayLinkedList(){
        head = new Node<T>(null,null,null);
//        head = new Node<T>(head,head,null); 这样写不生效，head的前后都为空，必须执行下面那行才生效，奇怪？待研究
        head.pre = head.next = head;
        count = 0;
    }

    public Node<T> getByIndex(int index) {
        if(index < 0 ||index >= count){
            throw new IndexOutOfBoundsException();
        }
        if(index<count/2){
            Node<T> node = head;
            for(int i = 0 ; i < index ; i ++){
                node = node.next;
            }
            return node;
        }else {
            Node<T> node = head.pre;
            //count个数之前间隔 count-1，如果从第一个数开始就是count-1，如果从第二个数开始，就是 count -1 -1 = (count-1)-(2-1) = count - 1 - index
            int end = count-1-index;
            for(int i = 0 ; i < end ; i ++){
                node = node.pre;
            }
            return node;
        }
    }

    public void insetNodeBeforeIndex(int index,T t){
        Node<T> nodeindex = getByIndex(index);
        Node<T> node = new Node<T>(nodeindex.pre,nodeindex,t);
        //重要的是nodeindex 和 nodeindexpre 之间的两条指针
        nodeindex.pre.next = node;
        nodeindex.pre = node;
        count++;
    }

    public void insetNodeAfterIndex(int index,T t){
        Node<T> nodeindex = getByIndex(index);
        Node<T> node = new Node<T>(nodeindex,nodeindex.next,t);
        //重要的是nodeindex 和 nodeindexnext 之间的两条指针
        nodeindex.next.pre = node;
        nodeindex.next = node;
        count++;
    }

    public void removeByIndex(int index) {
        Node<T> nodeindex = getByIndex(index);
        nodeindex.pre.next = nodeindex.next;
        nodeindex.next.pre = nodeindex.pre;
        nodeindex = null;
        count--;
    }

    public void addLast(T t){
        Node<T> node = new Node<T>(head.pre,head,t);
        head.pre.next = node;
        head.pre = node;
        count ++;
    }

    private <T> T showVal(Node<T> tNode){
        if(tNode.val==null){
            return null;
        }
        System.out.println(tNode.val);
        return (T) showVal(tNode.next);
    }

    public static void main(String[] args) {

        TwowayLinkedList<String> s = new TwowayLinkedList<String>();
        s.addLast("我");
        s.addLast("是");
        s.addLast("谢");
        s.addLast("宇");
        s.addLast("鹏");
        s.showVal(s.head.next);

    }
}
