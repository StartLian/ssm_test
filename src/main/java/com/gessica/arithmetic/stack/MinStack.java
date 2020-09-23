package com.gessica.arithmetic.stack;

import java.util.Deque;
import java.util.LinkedList;
/**
 * 最小栈：利用栈先进后出，创建辅助栈，将每一次存入的数据，与辅助栈顶数据对比，存入小值
 * @author wanji
 *
 */
public class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }
    
    public void pop() {
        xStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return xStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
    public static void main(String[]  agrs) {
    	MinStack minStack = new MinStack();
    	minStack.push(-2);
    	minStack.push(0);
    	minStack.push(-3);
    	int getMin = minStack.getMin();   //--> 返回 -3.
    	System.out.println("getMin:"+getMin);
    	minStack.pop();
    	System.out.println("getMin:"+getMin);
    	int top = minStack.top();     // --> 返回 0.
    	System.out.println("top:"+top);
    	int getMin2 = minStack.getMin(); //  --> 返回 -2.
    	System.out.println("getMin2:"+getMin2);

    }
}
