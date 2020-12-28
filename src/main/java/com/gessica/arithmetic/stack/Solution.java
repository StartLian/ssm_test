package com.gessica.arithmetic.stack;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		
	}
	/******************使用两个栈，实现队列*************************/
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() <= 0) {
            while (stack1.size() != 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    /******************使用两个栈，实现队列*************************/
}
