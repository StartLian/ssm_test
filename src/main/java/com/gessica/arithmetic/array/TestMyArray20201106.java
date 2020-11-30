package com.gessica.arithmetic.array;

import java.util.ArrayList;
import java.util.Arrays;

public class TestMyArray20201106 {

	public static void main(String[] args) {
		TestMyArray20201106 myArray = new TestMyArray20201106();
		int[] a = {-10, 0 ,10 ,10,20 ,-10, -40, -40};
		ArrayList<ArrayList<Integer>> threeSum =myArray.threeSum(a);
		System.out.println(threeSum.toString());
	}

	private ArrayList<ArrayList<Integer>> threeSum(int[] a) {
		ArrayList<ArrayList<Integer>> resp = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(a);
		int k = a.length-1;
		for (int i = 0; i < a.length; ++i) {
			int j=i+1;
			int target = -a[i];
			while (j<k) {
				if (a[j]+a[k]>target) {
					--k;
				} else if (a[j]+a[k]<target) {
					++j;
				} else {
					 System.out.println("j:"+j+" k:"+k);
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(0, a[i]);
					temp.add(1, a[j]);
					temp.add(2, a[k]);
					resp.add(temp);
					//去除左端重复
					while (j<k&&a[j]==a[j+1]) {
						++j;
					}
					//去除右端重复
					while (j<k&&a[k]==a[k-1]) {
						--k;
					}
					++j;
					--k;
				}
			}
			while (i+1<a.length&&a[i]==a[i+1]) {
				++i;
			}
		}
		return resp;
	}

}
