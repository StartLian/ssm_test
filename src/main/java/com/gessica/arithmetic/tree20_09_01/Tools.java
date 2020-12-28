package com.gessica.arithmetic.tree20_09_01;

import java.util.LinkedList;
import java.util.Stack;



/**
 * 前中后、层级、深度、叶子节点个数
 * @author wanji
 *
 */
class Tools{
    public static TreeNode createBiTree() {  //先序遍历创建二叉树
        System.out.print("请按先序次序依次输入二叉树的值，#号表示建立空树：");
        int input = 1;
        TreeNode initBiTree = new TreeNode(input);
        initBiTree.val=input;
        initBiTree.left=(Tools.createBiTree());
        initBiTree.right=(Tools.createBiTree());
        return initBiTree;
    }

    public static void preOrderTraverse(TreeNode initBiTree) { //先序遍历
        if(initBiTree != null) {
            System.out.print(initBiTree.val);
            Tools.preOrderTraverse(initBiTree.left);
            Tools.preOrderTraverse(initBiTree.right);
        }
    }

    public static void inOrderTraverse(TreeNode initBiTree) {  //中序遍历
        if(initBiTree != null) {
            Tools.inOrderTraverse(initBiTree.left);
            System.out.print(initBiTree.val);
            Tools.inOrderTraverse(initBiTree.right);
        }
    }

    public static void postOrderTraverse(TreeNode initBiTree) {  //后序遍历
        if(initBiTree != null) {
            Tools.postOrderTraverse(initBiTree.left);
            Tools.postOrderTraverse(initBiTree.right);
            System.out.print(initBiTree.val);
        }
    }

    public static void levelOrderTraverse(TreeNode initBiTree) {  //层序遍历
        if(initBiTree != null) {
            LinkedList<TreeNode> linkedList = new LinkedList<TreeNode>();
            linkedList.offer(initBiTree);
            while(!linkedList.isEmpty()) {
                initBiTree = linkedList.poll();
                if(initBiTree.left != null) {
                    linkedList.offer(initBiTree.left);
                }
                if(initBiTree.right != null) {
                    linkedList.offer(initBiTree.right);
                }
                System.out.print(initBiTree.val);
            }
        }
    }

    public static int biTreeDepth(TreeNode initBiTree) { //求二叉树深度
        if(initBiTree != null) {
            int l = Tools.biTreeDepth(initBiTree.left);
                    int r = Tools.biTreeDepth(initBiTree.right);
                    if(l > r) {
                        return l + 1;
                    }else {
                            return r + 1;
                    }
        }else {
            return 0;
        }
    }

    public static int biTreeNodeCount(TreeNode initBiTree) {  //求叶节点个数
        if(initBiTree != null) {
            int l = Tools.biTreeNodeCount(initBiTree.left);
            int r = Tools.biTreeNodeCount(initBiTree.right);
            if(l == 0 && r == 0) {
                return 1;
            }else {
                return l + r;
            }
        }else {
            return 0;
        }
    }
    /**
    * 给定一个二叉树, 检查它是否是镜像对称的
    * 例如以下是镜像对称的
    *      1
    *     / \
    *    2   2
    *   / \ / \
    *  3  4 4  3
    *
    * 下面这个则不是镜像对称的
    *      1
    *     / \
    *    2   2
    *     \   \
    *      3   3
    *
    * TreeNode类的定义:
    *
    * @param TreeNode 一颗二叉树
    * @return boolean 是否是对称的
    */

    // 以下给出TreeNode类, 请勿修改
    static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }

    static String temp="";
    public static boolean isTreeSymmetric(TreeNode root) {
     //TODO your code goes here...
    	
    	TreeNode root1 = root;
    	//求出镜像
    	Mirror1(root1);
    	//遍历对比
    	String string = preOrderTraveral(root);
    	temp = "";
    	String string1 = preOrderTraveral(root1);
    	return string.equals(string1);
    }
    /**
     * 前序遍历
     * @param root
     * @return
     */
    public static String preOrderTraveral(TreeNode root){
        if(root == null){
            return temp;
        }
        temp +=root.val;
        preOrderTraveral(root.left);
        preOrderTraveral(root.left);
        return temp;
    }
    /**
     * 求镜像
     * @param root
     */
    public static void Mirror1(TreeNode root) {
    	if (root == null) {
			return;
		}
        if(root.left != null || root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            Mirror1(root.left);
            Mirror1(root.right);
        }
    }
    public static void Mirror2(TreeNode root) {
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	stack.push(root);
    	while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (node.left != null || node.right != null) {
				TreeNode temp = node.left;
				root.left = root.right;
	            root.right = temp;
			}
			if (node.left != null) {
				stack.push(node.left);
			}
			if (node.right != null) {
				stack.push(node.right);
			}
		}
    	
    }
}
