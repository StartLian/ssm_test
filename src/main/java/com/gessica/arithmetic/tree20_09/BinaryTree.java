package com.gessica.arithmetic.tree20_09;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		for (int i = 0; i < 5; i++) {
			linkedList.add(i);
			linkedList.add(i*i);
			linkedList.add(i*(i-1));
		}
        Node root = PrintBinaryTree.createTreeNode(linkedList);
        System.out.print("层序遍历:");
        PrintBinaryTree.levelTraversal(root);
        System.out.println("带行号的层序遍历:");
        PrintBinaryTree.levelTraversalWithLineNo(root);
	}

}
