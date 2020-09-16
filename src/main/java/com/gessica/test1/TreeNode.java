package com.gessica.test1;

import java.util.LinkedList;

public class TreeNode {
    public int data;
    public TreeNode leftChild;
    public TreeNode rightChild;

    public TreeNode(int data){
        this.data = data;
    }
    /**
     * 构建二叉树
     * @param list   输入序列
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> list){
        TreeNode node = null;
        if(list == null || list.isEmpty()){
            return null;
        }
        Integer data = list.removeFirst();
        if(data!=0){
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(list);
            node.rightChild = createBinaryTree(list);
            return node;
        }else {
        	return null;
        }
    }
    /**
     * 二叉树前序遍历   根-> 左-> 右
     * @param node    二叉树节点
     */
    public static void preOrderTraveral(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(node.data+" ");
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }
    
    /**
     * 二叉树中序遍历   左-> 根-> 右
     * @param node   二叉树节点
     */
    public static void inOrderTraveral(TreeNode node){
        if(node == null){
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.print(node.data+" ");
        inOrderTraveral(node.rightChild);
    }
    
    /**
     * 二叉树后序遍历   左-> 右-> 根
     * @param node    二叉树节点
     */
    public static void postOrderTraveral(TreeNode node){
        if(node == null){
            return;
        }
        postOrderTraveral(node.leftChild);
        postOrderTraveral(node.rightChild);
        System.out.print(node.data+" ");
    }
    public static void levelOrder(TreeNode root){
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            root = queue.pop();
            System.out.print(root.data+" ");
            if(root.leftChild!=null) queue.add(root.leftChild);
            if(root.rightChild!=null) queue.add(root.rightChild);
        }
    }
    public static void levelOrder2(TreeNode root){
    	LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	while(!queue.isEmpty()){
    		root = queue.poll();
    		if(root.leftChild!=null) queue.add(root.leftChild);
    		if(root.rightChild!=null) queue.add(root.rightChild);
    		System.out.print(root.data+" ");
    	}
    }
    public static int biTreeDepth(TreeNode root) { //求二叉树深度
        if(root != null) {
            int l = biTreeDepth(root.leftChild);
                    int r = biTreeDepth(root.rightChild);;
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
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
//		for (int i = 0; i < 15; i++) {
//			linkedList.add(i);
//		}
		
		linkedList.add(5);
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(0);
		linkedList.add(7);
		linkedList.add(4);
		linkedList.add(0);
		linkedList.add(6);
		TreeNode createBinaryTree = createBinaryTree(linkedList);
		preOrderTraveral(createBinaryTree);
		System.out.println("");
		levelOrder(createBinaryTree);
		System.out.println("");
		levelOrder2(createBinaryTree);
		System.out.println("");
		int biTreeDepth = biTreeDepth(createBinaryTree);
		System.out.println("biTreeDepth:"+biTreeDepth);
		
    }
}