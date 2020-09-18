package com.gessica.arithmetic.tree20_09_01;

public class Main {
	   public static void main(String[] args) {
	        InitBiTree initBiTree = Tools.createBiTree();
	        System.out.println("——————先序遍历——————");
	        Tools.preOrderTraverse(initBiTree);
	        System.out.println();
	        System.out.println("——————中序遍历——————");
	        Tools.inOrderTraverse(initBiTree);
	        System.out.println();
	        System.out.println("——————后序遍历——————");
	        Tools.postOrderTraverse(initBiTree);
	        System.out.println();
	        System.out.println("——————层序遍历——————");
	        Tools.levelOrderTraverse(initBiTree);
	        System.out.println();
	        System.out.println("——————二叉树深度——————");
	        System.out.println(Tools.biTreeDepth(initBiTree));
	        System.out.println("——————叶子结点个数——————");
	        System.out.println(Tools.biTreeNodeCount(initBiTree));
	    }
}
