package com.gessica.arithmetic.art2021;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution0501 {
	

	public static void main(String[] args) {
		for (String string : args) {
			
		}
		//反转链表
		/*LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(7);
		linkedList.add(5);
		TreeList creatTree = creatList(linkedList);
		System.out.println("creatTree:"+creatTree.value);

		TreeList creatTree1 = reverseList(creatTree);
		System.out.println("creatTree1:"+creatTree1.value);*/
		int[] arr = {4,9,6,5,3,8,2,7,1};
		int[] getleastNumbers = getleastNumbers(arr,3);
		int index = 0;
		for (int i : getleastNumbers) {
			System.out.print( " "+getleastNumbers[index++]);
		}
	}
	/**
	 * 创建链表
	 * @2021年5月24日上午11:16:23
	 * @param @param ll
	 * @param @return 参数
	 * @return TreeList 返回类型
	 * @param ll
	 * @return
	 */
	public static TreeList creatList(LinkedList<Integer> ll) {
		TreeList treeList = null;
		if(ll.isEmpty()) {
			return null;
		}
		Integer poll = ll.poll();
		if (poll != 0) {
			treeList = new TreeList(poll);
			treeList.next =creatList(ll);
		}
		return treeList;
	}
	/**
	 * 反转链表
	 * @2021年5月24日上午10:59:12
	 * @param @param head
	 * @param @return 参数
	 * @return TreeList 返回类型
	 * @param head
	 * @return
	 */
	public static TreeList reverseList(TreeList head) {
		TreeList next = null;
		TreeList pre = null;
		while(head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	
	/**
	 * 寻找最小K个数----利用快排
	 * @2021年5月24日下午1:30:44
	 * @param @param arr
	 * @param @param k
	 * @param @return 参数
	 * @return int[] 返回类型
	 * @param arr
	 * @param k
	 * @return
	 */
	public static int[] getleastNumbers(int[] arr,int k) {
		//k-1表是要找k-1下标的数
		return quickSearck(arr,0,arr.length-1,k-1);
		
	}
	//
	private static int[] quickSearck(int[] arr, int l, int h, int k) {
		//每次切分，找到排序后下标为j的数据，如果j恰好等于k，就返回j以及左边的所有数据
		int j = partion(arr,l,h);
		if(j == k) {
			return Arrays.copyOf(arr, j+1);
		}
		
		return j > k ? quickSearck(arr ,l,j-1,k) : quickSearck(arr ,j+1,h,k);
	}
	//快排切分，返回下标j，使得比j小的数据都在j的左边，比j大的数，都在j的右边
	private static int partion(int[] arr, int l, int h) {
		int target = arr[l];
		int i = l;
		int j = h+1;
		/*if (l >= h) {
			return j ;
		}*/
		while(j>i) {
			while(++i < h && arr[i] < target);
			while(--j > l && arr[j] > target);
			if(j>i) {
				int t = arr[j];
				arr[j] = arr[i];
				arr[i] = t;
			}
		}
		arr[l] = arr[j];
		arr[j] = target;
		
//		partion(arr,j+1,h);
//		partion(arr,l,j-1);
		return j;
		
		
	}
	
	
	

}
