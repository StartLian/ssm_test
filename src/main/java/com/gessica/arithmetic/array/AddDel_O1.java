package com.gessica.arithmetic.array;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * https://blog.csdn.net/gaixiaoyang123/article/details/104625305
 * 设计一种数据结构，实现常数时间的增删改查
 * @author wanji
 * @2020年12月14日下午6:13:48
 */
public class AddDel_O1 {

	private HashMap<Integer,Integer> hashMap;
	private ArrayList<Integer> arrayList;
	public static void main(String[] args) {
		

	}
	public AddDel_O1() {
		hashMap = new HashMap<Integer,Integer>();
		arrayList = new ArrayList<Integer>();
		
	}
	public boolean insert(int val) {
		if (arrayList.contains(val)) {
			return false;
		}
		hashMap.put(val, arrayList.size());
		arrayList.add(arrayList.size(),val);
		return true;
	}
	
	public boolean remove(int val) {
		if (!arrayList.contains(val)) {
			return false;
		}
		Integer lastElement = arrayList.get(arrayList.size()-1);
		Integer index = hashMap.get(val);
		arrayList.set(index, lastElement);//在指定位置替换值
		hashMap.put(lastElement, index);
		
		arrayList.remove(arrayList.size()-1);
		hashMap.remove(val);
		return true;
	}

}
