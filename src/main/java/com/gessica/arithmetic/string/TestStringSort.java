package com.gessica.arithmetic.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class TestStringSort {

	public static void main(String[] args) {
		TestStringSort stringSort = new TestStringSort();
		ArrayList<String> permutation = stringSort.Permutation("ABCC");
		System.out.println(permutation.toString());
	}
	char[] charArray ;
	int len;
	private HashSet<String> set;
	private ArrayList<String> res;
	private ArrayList<String> Permutation(String string) {
		set = new HashSet<String>();
		res = new ArrayList<String>();
		charArray = string.toCharArray();
		len = charArray.length;
		ArrayList<Character> arrayList = new ArrayList<Character>();
		for (Character character : charArray) {
			arrayList.add(character);
		}
		int k = 0;
		next(0,arrayList);
		ArrayList<String> arrayList2 = new ArrayList<String>(set);
		Collections.sort(arrayList2);
		return arrayList2;
	}
	private void next(int k, ArrayList<Character> arrayList) {
		if (k == len) {
			String string = new String(charArray);
			if (!set.contains(string)) {
				set.add(string);
			}
		}else {
			for (int i = 0; i < arrayList.size(); i++) {
				char c = arrayList.get(i);
				ArrayList<Character> templist = new ArrayList<Character>(arrayList);
				templist.remove(i);
				charArray[k] = c;
				next(k+1,templist);
			}
		}
		
	}

}
