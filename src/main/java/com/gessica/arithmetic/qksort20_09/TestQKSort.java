package com.gessica.arithmetic.qksort20_09;

public class TestQKSort {

	public static void main(String[] args) {
		 int[] arr = {10,7,2,4,7, 62,3,4,2,1,8,9,19};

	        quickSort(arr, 0, arr.length-1);

	        for (int i = 0; i < arr.length; i++) {

	            System.out.print(arr[i]+" ");

	        }

	}

	private static void quickSort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		if (high<low) {
			return;
		}
		int i,j,targer,temp;
		i=low ;
		j=high;
		targer = arr[low];
		
		while(i<j) {
			//必须右端指针左移
			while (arr[j]>=targer && i<j) {
				--j;
			}
			//左端指针右移
			while (arr[i]<=targer && i<j) {
				++i;
			}
			//交换
			if (i<j) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j]=temp;
			}
		}
		//调换基数
		arr[low] = arr[i];
		arr[i] = targer;
		
		//必须以j为基准
//		左边小于arr[i]，排序
		quickSort(arr,low,j-1);
//		右边大于arr[i]，排序
		quickSort(arr,j+1,high);
		
		
	}

}
