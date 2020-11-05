package com.gessica.test;

import java.util.stream.IntStream;

public class ReOrderString {
	int chrsindex =16;
	int chrs2index=16;
	int tempindex =16;
	public static void main(String[] args) {
		
		ReOrderString reOrderString = new ReOrderString();
		String string = reOrderString.getString("my_name____is__dd");
		System.out.println("String："+string);
	}
//	输入：“my_name____is__dd”
//	输出：“dd_is____name__my” 
	public String getString(String str) {
		int templen = str.length();
		char[] chrs = new char[templen];
		char[] chrs2 = new char[templen];
		char[] chrs3 = new char[templen];
		char temp = '_';
		for (int i = 0;i<templen;i++) {
			char charAt = str.charAt(i);
			if (charAt==temp) {
				chrs[i] = temp;
			}else {
				chrs2[i] = charAt;
			}
		}
		
		for (int i = 0;i<templen;i++) {
			if (chrs[chrsindex-i] != temp) {
				chrs3[i] = chrs2[chrs2index-i];
			}else {
				chrs3[i] = '_';
			}
		}
		for (int i = 0;i<templen;i++) {
			if (chrs[chrsindex-i] != temp) {
				int tempLen1 =1;
				boolean isflage = true;
				while (isflage) {
					if (chrs[chrsindex-(i++)] == temp) {
						isflage = false;
					}
					tempLen1++;
				}
				i -= tempLen1;
				for(int k = tempLen1;k>0;k--) {
					chrs3[i++] = chrs2[chrs2index-k];
				}
			}else {
				chrs3[i] = '_';
			}
		}
		return String.copyValueOf(chrs3);
	}

}
