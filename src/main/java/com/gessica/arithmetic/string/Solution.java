package com.gessica.arithmetic.string;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String addsum = addsum("12345612340000","1234");
		System.out.println(addsum);
	}
	public static String addsum(String s,String t) {
		char[] charArray1 = s.toCharArray();
		char[] charArray2 = t.toCharArray();
		int len1 = charArray1.length-1;
		int len2 = charArray2.length-1;
		StringBuffer buffer = new StringBuffer();
		int next = 0;
		while (len1>=0 || len2>=0) {
			int temp = next;
			if (len1>=0) {
				temp += charArray1[len1--]-'0';
			}
			if (len2>=0) {
				temp += charArray2[len2--]-'0';
			}
			int a = temp%10;
			next = temp/10;
			buffer.append(a);
		}
		System.out.println(new String(buffer));
		StringBuffer reverse = buffer.reverse();
		return new String(reverse);
	}

}
