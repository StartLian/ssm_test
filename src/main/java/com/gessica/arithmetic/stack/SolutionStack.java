package com.gessica.arithmetic.stack;

import java.util.Stack;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;

public class SolutionStack {
	private static Stack<Integer> stack1 = new Stack<Integer>();
	private static Stack<Integer> stack2 = new Stack<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		add(1);
		add(2);
		add(3);
		Integer integer = get();
		System.out.println("integer:"+integer);
		add(4);
		integer = get();
		System.out.println("integer:"+integer);
		integer = get();
		System.out.println("integer:"+integer);
		add(5);
		integer = get();
		System.out.println("integer:"+integer);
	}
	public static boolean add(Integer val) {
		stack1.push(val);
		return true;
	}
	public static Integer get() {
		if (stack2.size() == 0) {
			while (stack1.size() != 0) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
	

}
