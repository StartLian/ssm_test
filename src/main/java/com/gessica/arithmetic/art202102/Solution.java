package com.gessica.arithmetic.art202102;
/**
 * 20210220
 * @author wanji
 * @2021年2月20日上午9:35:02
 * 1.快排
 */
public class Solution {

	public static void main(String[] args) {
		   int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};

	        qkSort(arr, 0, arr.length-1);//arr.length-1重点

	        
	        for (int i = 0; i < arr.length; i++) {

	            System.out.print(arr[i]+" ");

	        }

	}
	/**
	 * 快排
	 * @2021年2月20日上午10:22:13
	 * @param @param strarr
	 * @param @param start
	 * @param @param end 参数
	 * @return void 返回类型
	 * @param strarr
	 * @param start
	 * @param end
	 */
	public static void  qkSort(int[] strarr,int start,int end) {
		int low =start;
		int high =end;
		//一定要有递归退出条件
		if (low>high) {
			return;
		}
		int target = strarr[start];
		int t;
		
		while(low<high) {
			//先右边
			while(target<=strarr[high] && low<high) {
				--high;
			}
			while(target>=strarr[low] && low<high) {
				++low;
			}
			if (low<high) {
				//高低交换
				t = strarr[high];
				strarr[high] =strarr[low];
				strarr[low] =t;
			}
		}
		//target交换
		strarr[start] = strarr[low];
		strarr[low] = target;
		//先左边
		qkSort(strarr,start,high-1);
		qkSort(strarr,high+1,end);
	}
}
