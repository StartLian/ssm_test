package com.gessica.arithmetic.heap;

public class TestHeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int []arr = {4,6,8,5,9};
		buildBigHeap(arr);
	}

	private static void buildBigHeap(int[] arr) {
		for (int i = arr.length/2-1; i >=0 ; i--) {
			adjustment(arr,i,arr.length);
		}
		System.out.println("大顶堆");
		for (int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println("");
		System.out.println("小顶堆");
		for (int j = arr.length-1; j >=0 ; j--) {
			swap(arr,0,j);
			adjustment(arr,0,j);
		}
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}

	/**
	 * 堆定最大值和堆尾最小值调换
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i]= arr[j];
		arr[j]=temp;
	}

	private static void adjustment(int[] arr, int i, int length) {
		int temp = arr[i];
		for (int k = 2*i+1; k < length; k = 2*k+1) {//从左支点开始
			if (k+1<length && arr[k]<arr[k+1]) {//正常左小右大
				++k;
			}
			//比较大的子节点和父节点
			if (arr[k]>temp) {//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
				arr[i] = arr[k];
				i =k;
			}else {
				break;
			}
		}
		arr[i] = temp;
		
	}
	

}
