package com.gessica.arithmetic.art2021;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 三月份第一篇
 * 1.冒泡排序
 * 2.倒序字符串
 * @author wanji
 * @2021年3月1日上午8:54:49
 */
public class Solution0301 {
	public static void main(String[] args) {
		/*int[] a=   {10,7,7,11,8,5,6,4,2,3,1};
		BubbleSort(a);*/
		
//		String my_name____is__dd = changeStr("my_name____is__dd");
		
		 int[] nums = {4,5,1,6,2,7,3,8};
	        GetLeastNumbers(nums,8);
	}
	/**
	 * //		输入：“my_name____is__dd”
//		输出：“dd_is____name__my” 
 * //	[d, d][_][i, s][_, _, _, _][n, a, m, e][_, _][m, y]
	 * @2021年3月1日上午9:23:24
	 * @param @param srcStr
	 * @param @return 参数
	 * @return String 返回类型
	 * @param srcStr
	 * @return
	 */
	public static String changeStr(String srcStr) {
		char[] chars = srcStr.toCharArray();
		int len = chars.length;
		ArrayList<String> list1 = new ArrayList<>();//存字符
		ArrayList<String> list2 = new ArrayList<>();//存_
		ArrayList<Character> list3 = new ArrayList<>();//
		for (int i = 0;i<len;i++){

			if (list3.size() != 0 && (list3.get(list3.size()-1) == '_' && chars[i] != '_')){//来字母了
				String tempStr = list3.toString();
				if (list3.get(0) == '_'){
					list2.add(tempStr);
				}else {
					list1.add(tempStr);
				}
				list3.clear();
			}else if (list3.size() != 0 && (list3.get(list3.size()-1) != '_' && chars[i] == '_')){//来——了
				String tempStr = list3.toString();
				if (list3.get(0) == '_'){
					list2.add(tempStr);
				}else {
					list1.add(tempStr);
				}
				list3.clear();
			}
			list3.add(chars[i]);
			if (i == len-1){
				String tempStr = list3.toString();
				if (list3.get(0) == '_'){
					list2.add(tempStr);
				}else {
					list1.add(tempStr);
				}
				list3.clear();
			}
		}
		StringBuffer sb = new StringBuffer();
		int index = 0;
		for (int k = list1.size()-1;k>=0;k-- ) {
			sb.append(list1.get(k));
			if ((index+1)<=list2.size()){
				sb.append(list2.get(index++));
			}
		}
		return sb.toString();
	}
	/**
	 * 冒泡排序
	 * @2021年3月1日上午9:44:07
	 * @param @param src 参数
	 * @return void 返回类型
	 * @param src
	 */
	public static void BubbleSort(int[] src){
		int len = src.length;
		int temp;
		//自己的
		for (int i = 0;i<len;i++){
			for (int  j=i+1;j<len;j++){
				if(src[i]>src[j]){
					temp = src[i];
					src[i] = src[j];
					src[j] = temp;
				}
			}
		}
		System.out.println("src = " + Arrays.toString(src));
		//网上的,这个应该是冒泡
		for (int j = 0; j < len - 1; j++){
			for (int i = 0; i < len - 1 - j; i++)
				if (src[i] > src[i + 1]){
					temp = src[i];
					src[i] = src[i + 1];
					src[i + 1] = temp;
				}
		}
		System.out.println("src = " + Arrays.toString(src));
	}
	/**
	 * 通过先构建大顶堆，在进行堆排序，找出最小K个数
	 * @2021年3月2日下午8:11:08
	 * @param @param src
	 * @param @param k 参数
	 * @return void 返回类型
	 * @param src
	 * @param k
	 */
	 public static void  GetLeastNumbers(int[] src, int k){
	        //构建长度K的大顶堆
	        int[] res = new int[k];
	        //1.将输入数组的前k个数放入结果数组，作为初始的k个数
	        for (int i = 0;i<k;i++){
	            res[i] = src[i];
	        }
	      //2.将结果数据构建成大根堆
	        buildMaxHeap(res,k);
	        for (int i = 0; i <  res.length; i++) {
	            System.out.println("result ："+res[i]+" ");
	        }
	        //调整大顶堆，达到获取最小k 个数
	      //3.遍历输入数组,每个数都与大根堆的根节点比较
	        for (int i = k ;i<src.length;i++){
	            if (src[i]<res[0]){
	                res[0] = src[i];
	                //4.重构大根堆
	                buildMaxHeap(res,k);
	            }
	        }
	        for (int i = 0; i <  res.length; i++) {
	            System.out.println("result2 ："+res[i]+" ");
	        }
	        //调整为小顶堆
	        // 5.调整大根堆，即堆排序
	        for(int i= res.length-1;i>=1;i--){
	            swap(res,i,0); // 将当前最大的数（w为0）放置到未排序数组的末尾
	            buildMaxHeap(res,i);
	        }
	        for (int i = 0; i <  res.length; i++) {
	            System.out.println("result3 ："+res[i]+" ");
	        }
	    }

	    private static void buildMaxHeap(int[] res, int len) {
	        for (int i = len/2-1;i>=0;i--){ //len/2-1最右下侧，父节点
	           just(res,len,i);
	        }
	    }

	    private static void just(int[] res, int len, int index) {
	        int left = index*2+1;
	        int right = index*2+2;
	        if (left <= len-1 && res[left]>res[index]){
	            swap(res,left,index);
	        }
	        if (right<=len-1 && res[right]>res[index]){
	            swap(res,right,index);
	        }
	    }

	    private static void swap(int[] res, int left, int index) {
	        int temp = res[left];
	        res[left] = res[index];
	        res[index] = temp;
	    }
}
