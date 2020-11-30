package com.gessica.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class SearchLongStr {
//	abcffdeg
//
//	输出最长无重复的子串，例如上述例子输出 abcf、fdeg

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchLongStr searchLongStr = new SearchLongStr();
		ArrayList<String> lists = searchLongStr.searchLongstr("abcffdeg");
		System.out.println(lists.toString());
		for (String string : lists) {
			System.out.println("string:"+string);
		}
		
	}
	public ArrayList<String> searchLongstr(String str) {
		char[] charArray = str.toCharArray();
		HashSet<Character> hashSet = new HashSet<Character>();
//		HashMap<String,Integer> hashMap = new  HashMap<String, Integer>();
		ArrayList<String> arrayList = new ArrayList<String>();
		ArrayList<Character> arrayList2 = new ArrayList<Character>();
		int tempindex = 0;
		int index = 0;
		String tempstr = "";
		for (Character c : charArray) {
			++index;
			++tempindex;
//			hashSet.add(c);
			if (!arrayList2.contains(c)) {
				arrayList2.add(c);
			}
			if (arrayList2.size()<tempindex) {
				tempstr = String.valueOf(arrayList2);
//				hashMap.put(tempstr, hashSet.size());
				arrayList.add(tempstr);
				arrayList2.clear();
				arrayList2.add(c);
				tempindex=0;
			}
			if (charArray.length == index) {
				tempstr = String.valueOf(arrayList2);
				arrayList.add(tempstr);
			}
		}
		
		return arrayList;
	}

}
