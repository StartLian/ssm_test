package com.gessica.arithmetic.bubblesort;

public class MyBubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {10,7,7,11,8,5,6,4,2,3,1};
		bubbleSort(a);
		for (int i : a) {
			System.out.print(i+" ");
		}
	}
	public static void bubbleSort(int[] arr ) {
		int k = arr.length-1;
		int temp;
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if (arr[j]>arr[j+1]) {
					temp = arr[j+1];
					arr[j+1] =arr[j];
					arr[j] =temp;
				}
			}
		}
	}

}
