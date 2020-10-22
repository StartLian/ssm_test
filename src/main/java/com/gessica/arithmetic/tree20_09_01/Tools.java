package com.gessica.arithmetic.tree20_09_01;

import java.util.LinkedList;
import java.util.Scanner;


/**
 * 前中后、层级、深度、叶子节点个数
 * @author wanji
 *
 */
class Tools{
    public static InitBiTree createBiTree() {  //先序遍历创建二叉树
        System.out.print("请按先序次序依次输入二叉树的值，#号表示建立空树：");
//        Scanner sc = new Scanner(System.in);
        String input = "ABC##DE#G##F###";
//        input = sc.next();
        if(input.equals("#")) {
            return null;
        }else {
            InitBiTree initBiTree = new InitBiTree();
            initBiTree.setData(input);
            initBiTree.setLchild(Tools.createBiTree());
            initBiTree.setRchild(Tools.createBiTree());
            return initBiTree;
        }
    }

    public static void preOrderTraverse(InitBiTree initBiTree) { //先序遍历
        if(initBiTree != null) {
            System.out.print(initBiTree.getData());
            Tools.preOrderTraverse(initBiTree.getLchild());
            Tools.preOrderTraverse(initBiTree.getRchild());
        }
    }

    public static void inOrderTraverse(InitBiTree initBiTree) {  //中序遍历
        if(initBiTree != null) {
            Tools.inOrderTraverse(initBiTree.getLchild());
            System.out.print(initBiTree.getData());
            Tools.inOrderTraverse(initBiTree.getRchild());
        }
    }

    public static void postOrderTraverse(InitBiTree initBiTree) {  //后序遍历
        if(initBiTree != null) {
            Tools.postOrderTraverse(initBiTree.getLchild());
            Tools.postOrderTraverse(initBiTree.getRchild());
            System.out.print(initBiTree.getData());
        }
    }

    public static void levelOrderTraverse(InitBiTree initBiTree) {  //层序遍历
        if(initBiTree != null) {
            LinkedList<InitBiTree> linkedList = new LinkedList<InitBiTree>();
            linkedList.offer(initBiTree);
            while(!linkedList.isEmpty()) {
                initBiTree = linkedList.poll();
                if(initBiTree.getLchild() != null) {
                    linkedList.offer(initBiTree.getLchild());
                }
                if(initBiTree.getRchild() != null) {
                    linkedList.offer(initBiTree.getRchild());
                }
                System.out.print(initBiTree.getData());
            }
        }
    }

    public static int biTreeDepth(InitBiTree initBiTree) { //求二叉树深度
        if(initBiTree != null) {
            int l = Tools.biTreeDepth(initBiTree.getLchild());
                    int r = Tools.biTreeDepth(initBiTree.getRchild());
                    if(l > r) {
                        return l + 1;
                    }else {
                            return r + 1;
                    }
        }else {
            return 0;
        }
    }

    public static int biTreeNodeCount(InitBiTree initBiTree) {  //求叶节点个数
        if(initBiTree != null) {
            int l = Tools.biTreeNodeCount(initBiTree.getLchild());
            int r = Tools.biTreeNodeCount(initBiTree.getRchild());
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
        if(root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            Mirror1(root.left);
            Mirror1(root.right);
        }
    }
}
