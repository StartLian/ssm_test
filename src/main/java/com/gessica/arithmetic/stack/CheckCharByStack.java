package com.gessica.arithmetic.stack;

import java.util.Stack;

public class CheckCharByStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean valid = isValid("(())");
		System.out.println("valid:"+valid);
	}
/**
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 * @param str
 * @return
 */
	public static boolean isValid(String str) {
		char[] chars = str.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (Character c : chars) {
			if (stack.isEmpty()) {
				stack.add(c);
			}else if (c == stack.peek()) {//和栈顶数据比较,应该是“（（））”
				stack.add(c);
			}else{//
				if (c == ')' && stack.peek()=='(') {
					stack.pop();//出栈
				}else if (c == '}' && stack.peek()=='{') {
					stack.pop();//出栈
				}else if (c == ']' && stack.peek()=='[') {
					stack.pop();//出栈
				}
			}
		}
		return stack.isEmpty();
	}
}
