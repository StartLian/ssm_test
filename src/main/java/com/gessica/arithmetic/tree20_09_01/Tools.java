package com.gessica.arithmetic.tree20_09_01;

import java.util.LinkedList;
import java.util.Scanner;

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
}
