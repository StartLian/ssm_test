package com.gessica.test;

import java.util.ArrayList;

public class SearchTarget {

//	写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
//
//	每行的元素从左到右升序排列。
//	每列的元素从上到下升序排列。 
//
//	  [1,   4,  7, 11, 15],
//	  [2,   5,  8, 12, 19],
//	  [3,   6,  9, 16, 22],
//	  [10, 13, 14, 17, 24],
//	  [18, 21, 23, 26, 30]

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		7,[[1,2,8,9],[4,7,10,13]]
		int[][] array = new int[2][4];
		array[0][0]= 1;
		array[0][1]= 2;
		array[0][2]= 8;
		array[0][3]= 9;
		array[1][0]= 4;
		array[1][1]= 7;
		array[1][2]= 10;
		array[1][3]= 13;
		boolean searchTarget = searchTarget(array,7);
		System.out.println("searchTarget:"+searchTarget);
	}
	public static boolean searchTarget(int[][] array,int target) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		//行数
		int r = array.length;
		//列数
		int l = array[0].length;
		int temp = r>l ? l :r;
		for (int i= 0 ;i<temp;i++) {
			if (array[i][i]>target) {
				//i的上部分
				int j=i;
				int k=i;
				if (r>=temp) {
					for (j = i; j >= 0; j--) {
						System.out.println("i:"+i+" j:"+j);
						if (array[j][i]==target) {
							return true;
						}
                        if (array[j][i]<target) {
							break;
						}
					}
				}
				//i左部分
				if (l>=temp) {
					for (k = i; k >= 0; k--) {
						System.out.println("i:"+i+" k:"+k);
						if (array[i][k]==target) { 
							return true;
						}
                        if (array[i][k]<target) { 
							break;
						}
					}
				}
				if (array[i][0]>target&&array[0][i]>target) {
					System.out.println("i:"+i);
					return false;
				}
			}else if (array[i][i]==target) {
				System.out.println("ii:"+i);
				return true;
			}
		}
		System.out.println("false");
		return false;
	}

}
