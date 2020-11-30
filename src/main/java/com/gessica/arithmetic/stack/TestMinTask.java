package com.gessica.arithmetic.stack;

import java.util.LinkedList;

public class TestMinTask {

	LinkedList<Integer> minStatic = null;
	LinkedList<Integer> mStatic = null;
	public void push(Integer i) {
		minStatic.push(Math.min(minStatic.peek(), i));
		mStatic.push(i);
	}
	public void pop() {
		minStatic.pop();
		mStatic.pop();
	}
	public TestMinTask(){
		minStatic=new LinkedList<Integer>();
		mStatic=new LinkedList<Integer>();
		minStatic.push(Integer.MAX_VALUE);
	}
	public int getMin() {
		return minStatic.pop();
	}
	public int top() {
		return mStatic.peek();
	}
	
	public static void main(String[] args) {
		TestMinTask testMinTask = new TestMinTask();
		testMinTask.push(-2);
		testMinTask.push(0);
		testMinTask.push(-3);
		int getMin = testMinTask.getMin();   //--> 返回 -3.
    	System.out.println("getMin:"+getMin);
    	testMinTask.pop();
    	int top = testMinTask.top();     // --> 返回 0.
    	System.out.println("top:"+top);
    	int getMin2 = testMinTask.getMin(); //  --> 返回 -2.
    	System.out.println("getMin2:"+getMin2);
	}
}
