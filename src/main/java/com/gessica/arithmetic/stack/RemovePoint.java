package com.gessica.arithmetic.stack;

import java.util.Stack;

public class RemovePoint {
	/**
	 * 移除指定num
	 * @param head
	 * @param num
	 * @return
	 */
	public Node removeValue1(Node head, int num) {

	    Stack<Node> stack = new Stack<>();
	    while (head != null) {
	        if(head.value != num) {
	            stack.push(head);
	        }
	        head = head.next;
	    }
//	    相同点：大家都返回栈顶的值。
//
//	    不同点：peek 不改变栈的值(不删除栈顶的值)，pop会把栈顶的值删除。
	    while (!stack.isEmpty()) {

	        stack.peek().next = head;
	        head = stack.pop();
	    }

	    return head;
	}
}
