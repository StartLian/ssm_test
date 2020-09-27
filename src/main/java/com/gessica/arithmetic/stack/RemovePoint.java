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

	    while (!stack.isEmpty()) {

	        stack.peek().next = head;
	        head = stack.pop();
	    }

	    return head;
	}
}
