package com.gessica.arithmetic.tree20_09;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class TestTreeNode {

	TestTreeNode left;
	TestTreeNode right;
	int data;
	public TestTreeNode(int data) {
		this.data =data;
		
	}
	public static TestTreeNode creatTree(LinkedList<Integer> ll) {
		TestTreeNode testTreeNode = null ;
		if (ll.isEmpty()) {
			return null;
		}
		Integer temp = ll.poll();
		if (temp != 0) {
			testTreeNode = new TestTreeNode(temp);
			testTreeNode.left = creatTree(ll);
			testTreeNode.right = creatTree(ll);
			return testTreeNode;
		} else {
			return testTreeNode;
		}
		
	}
	/**
	 * 前序遍历 跟左右
	 * @param treeNode
	 */
	static int index = 0;
	public void preOrder(TestTreeNode treeNode,ArrayList<Integer> temp) {
		temp.add( treeNode.data);
		if (treeNode!=null) {
			System.out.print(treeNode.data+" ");
			if (treeNode.left!=null) {
				preOrder(treeNode.left,temp);
			}
			if (treeNode.right!=null) {
				preOrder(treeNode.right,temp);
			}
		}
	}
	/**
	 * 前序遍历 跟左右
	 * @param treeNode
	 */
//	public void preOrder(TestTreeNode treeNode) {
//		temp[index++] = treeNode.data;
//		if (treeNode!=null) {
//			System.out.print(treeNode.data+" ");
//			if (treeNode.left!=null) {
//				preOrder(treeNode.left);
//			}
//			if (treeNode.right!=null) {
//				preOrder(treeNode.right);
//			}
//		}
//	}
	/**
	 * 中序遍历 左跟右
	 * @param treeNode
	 */
	public void minOrder(TestTreeNode treeNode) {
		if (treeNode==null) {
			return;
		}
			if (treeNode.left!=null) {
				minOrder(treeNode.left);
			}
			System.out.print(treeNode.data+" ");
			if (treeNode.right!=null) {
				minOrder(treeNode.right);
			}
//			preOrder(treeNode.left);
//			System.out.print(treeNode.data+" ");
//			preOrder(treeNode.right);
	}
		/**
		  *  后序遍历 左右跟
		 * @param treeNode
		 */
	public void afterOrder(TestTreeNode treeNode) {
		if (treeNode!=null) {
			if (treeNode.left!=null) {
				afterOrder(treeNode.left);
			}
			if (treeNode.right!=null) {
				afterOrder(treeNode.right);
			}
			System.out.print(treeNode.data+" ");
		}
	}
	/**
	 * 深度
	 * @param treeNode
	 * @return
	 */
	public int deep(TestTreeNode treeNode) {
		
		if (treeNode!=null) {
			
				int l= deep(treeNode.left);
				int r= deep(treeNode.right);
				if (r>l) {
					return r+1;
				}else {
					return l+1;
					
				}
		}else {
			return 0;
		}
	}
	/**
	 * 层级遍历
	 * @param treeNode
	 * @return
	 */
	public void leaveOrder(TestTreeNode treeNode) {
		LinkedList<TestTreeNode> ll = new LinkedList<TestTreeNode>();
		ll.add(treeNode);
		while (!ll.isEmpty()) {
			treeNode = ll.poll();
			System.out.print(treeNode.data+" ");
			if (treeNode.left!=null) {
				ll.add(treeNode.left);
			}
			if (treeNode.right!=null) {
				ll.add(treeNode.right);
			}
		}
		
		
	}
	/**
	 * 非递归 前序遍历 跟左右
	 * @param treeNode
	 */
	public void preOrderStack(TestTreeNode node,ArrayList<Integer> temp) {
		Stack<TestTreeNode> stack = new Stack<TestTreeNode>();
		TestTreeNode treeNode = node;
        while(treeNode!=null || !stack.isEmpty()){
            //迭代访问节点的左孩子，并入栈
            while(treeNode != null){
                System.out.print(treeNode.data+" ");
                temp.add(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if(!stack.isEmpty()){
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
	}
//	public void preOrderStack(TestTreeNode node) {
//		Stack<TestTreeNode> stack = new Stack<TestTreeNode>();
//		TestTreeNode treeNode = node;
//		while(treeNode!=null || !stack.isEmpty()){
//			//迭代访问节点的左孩子，并入栈
//			while(treeNode != null){
//				System.out.print(treeNode.data+" ");
//				stack.push(treeNode);
//				treeNode = treeNode.left;
//			}
//			//如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
//			if(!stack.isEmpty()){
//				treeNode = stack.pop();
//				treeNode = treeNode.right;
//			}
//		}
//	}
	/**
	 * 非递归 中序遍历 左跟右
	 * @param treeNode
	 */
	public void midOrderStack(TestTreeNode node) {
		Stack<TestTreeNode> stack = new Stack<TestTreeNode>();
		TestTreeNode treeNode = node;
		while(treeNode!=null || !stack.isEmpty()){
			//迭代访问节点的左孩子，并入栈
			while(treeNode != null){
				stack.push(treeNode);
				treeNode = treeNode.left;
			}
			//如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
			if(!stack.isEmpty()){
				treeNode = stack.pop();
				System.out.print(treeNode.data+" ");
				treeNode = treeNode.right;
			}
		}
	}
	/**
	 * 非递归 后序遍历 左右跟
	 * @param treeNode
	 */
	public void afterOrderStack(TestTreeNode root) {
		Stack<TestTreeNode> s = new Stack<TestTreeNode>();
	       Stack<Integer> s2 = new Stack<Integer>();
	       Integer i = new Integer(1);
	       while(root!=null || !s.empty()){
	           while(root!=null){
	               s.push(root);
	               s2.push(new Integer(0));
	               root = root.left;
	           }
	           while(!s.empty() && s2.peek().equals(i)){
	               s2.pop();
	               System.out.print(s.pop().data+" ");
	           }
	           if(!s.empty()){
	               s2.pop();
	               s2.push(new Integer(1));
	               root =s.peek();
	               root = root.right;
	           }
	       }
	}
	public static void main(String[] args) {
//		44,18,22,40,34,36,31,1,41,30,19,27,16,32,9,3,12,39,20,4,11,
//		10,38,7,23,8,42,35,28,2,14,6,24,15,43,5,33,26,21,17,29,13,25,37
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		ll.add(5);
		ll.add(6);
		ll.add(7);
		ll.add(8);
		ll.add(9);
		TestTreeNode treeNode = creatTree(ll);
		System.out.println("递归前序");
		ArrayList<Integer> temp = new ArrayList<Integer>();
		treeNode.preOrderStack(treeNode,temp);
//		treeNode.preOrder(treeNode,temp);
        int[][] a = new int[3][temp.size()];
        
        for(int i = temp.size()-1;i>=0;i--){
            a[0][i] = temp.get(i);
        }
		System.out.println("");
		for (Integer integer : a[0]) {
			System.out.print(integer+" ");
		}
//		System.out.println("非递归前序");
//		treeNode.preOrderStack(treeNode);
//		System.out.println("");
//		System.out.println("递归中序");
//		treeNode.minOrder(treeNode);
//		System.out.println("");
//		System.out.println("非递归中序");
//		treeNode.midOrderStack(treeNode);
//		System.out.println("");
//		System.out.println("递归后序");
//		treeNode.afterOrder(treeNode);
//		System.out.println("");
//		System.out.println("非递归后序");
//		treeNode.afterOrderStack(treeNode);
//		System.out.println("");
//		System.out.println("深度");
//		int deep = treeNode.deep(treeNode);
//		System.out.println("deep:"+deep);
//		System.out.println("层级遍历");
//		treeNode.leaveOrder(treeNode);
		
		
		

	}

}
