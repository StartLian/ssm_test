package com.gessica.test1;

import java.util.LinkedList;
import java.util.Queue;

public class BitNode {
	int data;
    BitNode lchild;
    BitNode rchild;

    public void setNode(int data, BitNode lc, BitNode rc) {
        this.data = data;
        lchild = lc;
        rchild = rc;
    }

static int counter = 0;//定义一个静态计数变量

/**
     * 构造二叉树
     * 
     * @param root根节点
     * @param a数据源
     * @param i计数器
     * @return 根节点
     */
    public static BitNode createBiTree(BitNode root, int[] a, int i) {
        if (i < a.length) {
            if (a[i] == 0) {
                root = null;
            } else {
                BitNode lchild = new BitNode();
                BitNode rchild = new BitNode();
                System.out.println(a[i]+" "+counter);
                root.data = a[i];
                System.out.println("++");
                root.lchild = createBiTree(lchild, a, ++counter);
                System.out.println("--");
                root.rchild = createBiTree(rchild, a, ++counter);
                System.out.println("--++");
            }
        }
        return root;
    }

// 访问节点
    public static void visitTNode(BitNode node) {
        System.out.print(node.data + " ");
    }

// 层次遍历
    public static void levelTraverse(BitNode root) {
        Queue<BitNode> queue = new LinkedList<BitNode>();
        queue.offer(root);// 从根节点入队列
        while (!queue.isEmpty()) {// 在队列为空前反复迭代
            BitNode bitNode = queue.poll();// 取出队列首节点
            visitTNode(bitNode);
            if (bitNode.lchild != null)
                queue.offer(bitNode.lchild);// 左孩子入列
            if (bitNode.rchild != null)
                queue.offer(bitNode.rchild);// 右孩子入列
        }
    }
    static int index = 1;
    public static void levelTraverse1(BitNode root) {
    	Queue<BitNode> queue = new LinkedList<BitNode>();
    	queue.offer(root);// 从根节点入队列
    	while (!queue.isEmpty()) {// 在队列为空前反复迭代
    		BitNode bitNode = queue.poll();// 取出队列首节点
    		visitTNode(bitNode);
    		if ((++index)%2 != 0) {
    			if (bitNode.rchild != null)
        			queue.offer(bitNode.rchild);// 右孩子入列
    			if (bitNode.lchild != null)
    				queue.offer(bitNode.lchild);// 左孩子入列
			}else {
    			if (bitNode.lchild != null)
    				queue.offer(bitNode.lchild);// 左孩子入列
    			if (bitNode.rchild != null)
    				queue.offer(bitNode.rchild);// 右孩子入列
			}
    		
    	}
    }
    public static int biTreeDepth(BitNode root) { //求二叉树深度
        if(root != null) {
            int l = biTreeDepth(root.lchild);
                    int r = biTreeDepth(root.rchild);;
                    if(l > r) {
                        return l + 1;
                    }else {
                            return r + 1;
                    }
        }else {
            return 0;
        }
    }
public static void main(String[] args) {
        BitNode root = new BitNode();
        int[] a = { 1, 2, 3, 0, 0, 4, 0, 0, 5, 0, 0 };
        root = createBiTree(root, a, counter);
levelTraverse(root);
System.out.println("");
levelTraverse1(root);
System.out.println("");
int biTreeDepth = biTreeDepth(root);
System.out.println("biTreeDepth:"+biTreeDepth);
}
}
