package com.xieyupeng.springboot.studys.DataStructure;

/**
 * 最小堆，每个节点都比子节点要小即可
 */
public class HeapMin {

    private int[] data;
    private int size;
    private int maxSize;

    public HeapMin(int maxSize){
        this.maxSize = maxSize;
        size = 0;
        data = new int[maxSize];
        data[0] = 0;
    }

    private int leftChildPostion(int postion){
        return 2 * postion;
    }

    private int rightChildPostion(int postion){
        return 2 * postion + 1;
    }

    private int parentPostion(int postion){
        return postion / 2;
    }

    //是否是叶子节点（叶子节点不代表就是最后一层，只要没有孩子，都是叶子节点）
    private boolean isLeaf(int postion){
        return ((postion > size / 2)&&(postion < size));
    }

    //交换两者的位置
    private void swap(int postion1,int postion2){
        data[postion1] = data[postion1] + data[postion2];
        data[postion2] = data[postion1] - data[postion2];
        data[postion1] = data[postion1] - data[postion2];
    }

    public void insert(int value){
        if(++size>maxSize){
            return;
        }
        data[size] = value;
        int current = size;
        if(parentPostion(current) > 0 &&
                data[current] < data[parentPostion(current)]){
            swap(current,parentPostion(current));
            current = parentPostion(current);
        }
    }

    public void remove(int position){
        swap(position, size);
        size--;
        if (size != 0)
            pushdown(1);
    }

    //该节点和它两个子节点中最小的那个交换位置，重复直到找到位置
    private void pushdown(int position){
        int smallestchild;
        while (!isLeaf(position)) {
            smallestchild = leftChildPostion(position);
            if ((smallestchild < size)
                    && (data[smallestchild] > data[smallestchild + 1]))
                smallestchild = smallestchild + 1;
            if (data[position] <= data[smallestchild])
                return;
            swap(position, smallestchild);
            position = smallestchild;
        }
    }
}
