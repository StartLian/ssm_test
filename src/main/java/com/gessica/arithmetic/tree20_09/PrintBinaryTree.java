package com.gessica.arithmetic.tree20_09;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 层级遍历、加层级行号遍历
 * @author wanji
 *
 */
public class PrintBinaryTree {
	 /**
     * 层序遍历二叉树（每一行从左到右，整体上从上到下）
     * 主要思路：利用队列先进先出的性质保存顺序
     *
     * @param root 要遍历的二叉树的根节点
     */
    public static void levelTraversal(Node root) {
    	boolean flag =true;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp != null) {
                System.out.print(temp.value + "  ");
//                q.add(temp.left);
//            	q.add(temp.right);
                flag = !flag;
                if (flag) {
                	q.add(temp.left);
                	q.add(temp.right);
				}else {
					q.add(temp.right);
					q.add(temp.left);
				}
            }
        }
    }

    /**
     * 层序遍历二叉树（每一行从左到右，整体上从上到下）,并附带行号
     * 主要思路：利用队列先进先出的性质保存顺序来层序遍历二叉树。
     * 使用curLineLast与nextLineLast两个节点标志来标识遍历过程中当前行结尾节点与下一行结尾节点，
     * 再使用一个lineNo整形量来记录当前行号（初始设为1），并在curLineLast节点更替时，更新lineNo的值并按格式打印即可。
     * 注：nextLineLast始终指向最新遍历到的节点
     * @param root 要遍历的二叉树的根节点
     */
    public static void levelTraversalWithLineNo(Node root) {
        //  加入断言，保证root不为null
        assert root != null;
        //  curLineLast : 当前行结尾节点
        //  nextLineLast : 下一行结尾节点
        //  刚开始时，curLineLast与nextLineLast均指向根节点
        Node curLineLast = root, nextLineLast = root;
        //  设根节点所在的行为第1行
        int lineNo = 1;
        System.out.print(lineNo + " : ");
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            //  只有当前节点的子节点不为空时，nextLineLast才需要更改指向的目标
            if (temp.left != null) {
                q.add(temp.left);
                nextLineLast = temp.left;
            }
            if (temp.right != null) {
                q.add(temp.right);
                nextLineLast = temp.right;
            }
            System.out.print(temp.value + "  ");
            // 当出栈节点为当前行尾节点时，说明该换行了
            if (curLineLast == temp) {
                // 将当前行尾节点指向下一行尾节点
                curLineLast = nextLineLast;
                System.out.print(System.lineSeparator() + ++lineNo + " : ");
            }
        }
    }

	public static Node createTreeNode(LinkedList<Integer> list) {
		 Node node = null;
	        if(list == null || list.isEmpty()){
	            return null;
	        }
	        Integer data = list.removeFirst();
	        if(data!=null){
	            node = new Node(data);
	            node.left = createTreeNode(list);
	            node.right = createTreeNode(list);
	        }
	        return node;
	}
}
