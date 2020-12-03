package com.gessica.arithmetic.tree20_09_01;

import java.util.LinkedList;
import java.util.Stack;

public class Tools_2 {

	//左-中-右
	public void preOrder(TreeNode treeNode) {
		if (treeNode == null) {
			return;
		}
		System.out.print(treeNode.getData());
		preOrder(treeNode.getLchild());
		preOrder(treeNode.getRchild());
	}
	//层级便利
	public void levalOrder(TreeNode treeNode) {
		if (treeNode ==null) {
			return ;
		}
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		list.add(treeNode);
		while(!list.isEmpty()) {
			TreeNode node = list.pop();
			System.out.println(node.getData());
			if (node.getLchild() != null) {
				list.add(node.getLchild());
			}
			if (node.getRchild() != null) {
				list.add(node.getRchild());
			}
		}
	}
	//二叉树深度
	public int deep(TreeNode treeNode) {
		if (treeNode ==null) {
			return 0;
		}
		int l = deep(treeNode.getLchild());
		int r = deep(treeNode.getRchild());
		if (l>r) {
			return l+1;
		}else {
			return r+1;
		}
	}
	//二叉树叶子结点个数
	public int nodeNum(TreeNode treeNode) {
		if (treeNode ==null) {
			return 0;
		}
		int l = deep(treeNode.getLchild());
		int r = deep(treeNode.getRchild());
		if (l== 0 && r ==0) {
			return 1;
		}else {
			return r+l;
		}
	}
	//非递归前序
	public void preOrderStack(TreeNode treeNode) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = treeNode;
		while(!stack.isEmpty() || treeNode != null) {
			while(node != null) {
				System.out.println(node.getData());
				stack.push(node);
				node = node.getLchild();
			}
			if(!stack.isEmpty()) {
				TreeNode node2 = stack.pop();
				node2 =node2.getRchild();
			}
		}
	}
	//非递归中序
	public void midOrderStack(TreeNode treeNode) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = treeNode;
		while(!stack.isEmpty() || treeNode != null) {
			while(node != null) {
				stack.push(node);
				node = node.getLchild();
			}
			if(!stack.isEmpty()) {
				TreeNode node2 = stack.pop();
				System.out.println(node2.getData());
				node2 =node2.getRchild();
			}
		}
	}
}
