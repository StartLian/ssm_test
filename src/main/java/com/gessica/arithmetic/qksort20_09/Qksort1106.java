package com.gessica.arithmetic.qksort20_09;

public class Qksort1106 {

	public static void main(String[] args) {
		//"my__name___Is__dd"
		//"dd__is___name__my"
		String str = "my__name___Is__dd";
		char[] chars =new char[str.length()];
		for(int i= 0; i<str.length();i++) {
			chars[i] = str.charAt(i);
		}
		getNewString (chars,0,chars.length-1);
		for (char c : chars) {
			
			System.out.print(c);
		}
	}

	private static void getNewString(char[] chars,int low,int high) {
		// TODO Auto-generated method stub
		char t = ' ';
		int i = low;
		int j = high;
		char tempchar = chars[low];
		while(i<j) {
			while(chars[i]=='_'&&i<j) {
				i++;
			}
			while(chars[j]=='_'&&i<j) {
				j--;
			}
			if (i<j) {
				t= chars[i];
				chars[i]=chars[j];
				chars[j]=t;
				i++;
				j--;
			}
		}
		
	}

}
