package com.gessica.arithmetic.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
/**
 * 字符串全部排序
 * @author wanji
 * @2020年10月26日上午11:09:14
 */
public class StringSort {

	public static void main(String[] args) {
		StringSort stringSort = new StringSort();
		ArrayList<String> permutation = stringSort.Permutation("ABCC");
 		for (String string : permutation) {
			System.out.print(string+" ");
		}
	}
	ArrayList<String> res = new ArrayList<String>();
    HashSet<String> set = new HashSet<String>();
    int length;
//    HashMap<Character, Integer> sta = new HashMap<Character, Integer>();
    char [] array;
    public ArrayList<String> Permutation(String str) {
        set = new HashSet<String>();
        res = new ArrayList<String>();
        if(str.length() == 0) return new ArrayList<String>();
        init(str);
        int k = 0;
        ArrayList<Character> touse = new ArrayList<Character>();
        for(char c : array) {
            touse.add(c);
        }
        next(k, touse);
        res = new ArrayList<String>(set);
        Collections.sort(res);
        return res;
    }
 
    public void init(String str) {
        length = str.length();
        array = str.toCharArray();
        Arrays.sort(array);
//        for (char c : array) {
//            if (sta.containsKey(c))
//                sta.put(c, sta.get(c) + 1);
//            else
//                sta.put(c, 1);
//        }
    }
  public void next(int k, ArrayList<Character> touse) {
 
        if (k == length) {
            String s = new String(array);
            if(!set.contains(s)) set.add(new String(array));
        }
        else {
            for (int i=0; i<touse.size(); i++) {
                char c = touse.get(i);
                ArrayList<Character> to_use = new ArrayList<Character>(touse);
                to_use.remove(i);
                array[k] = c;
                next(k + 1, to_use);
            }
        }
    }

  /**
   * 将字符串中的空格，替换成%20
   * @2020年11月30日下午6:43:00
   * @param @param str
   * @param @return 参数
   * @return String 返回类型
   * @param str
   * @return
   */
  public String replaceSpace(StringBuffer str) {
	  StringBuffer sb = new StringBuffer();
	  for(int i = 0;i<str.length();i++) {
		  char c = str.charAt(i);
		  if (c==' ') {
			  sb.append("%20");
			}else {
				sb.append(c);
			}
	  }
	  return sb.toString();
  }
}
