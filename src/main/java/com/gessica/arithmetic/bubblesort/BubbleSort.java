package com.gessica.arithmetic.bubblesort;
/**
 *冒泡
 *https://www.jianshu.com/p/1458abf81adf
 * @author wanji
 *
 */
public class BubbleSort {

	public static void main(String[] args) {
		int arr[] = { 5, 8, 6, 3, 9, 2, 1, 7 };
		for (int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+",");
		}
		System.out.println("");
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.BubbleSort(arr, arr.length);
		for (int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+",");
		}
	}

	public void BubbleSort(int a[], int len){
		int i, j, temp;
		for (j = 0; j < len - 1; j++){
			for (i = 0; i < len - 1 - j; i++)
			if (a[i] > a[i + 1]){
				temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
			}
		}
	}
}
