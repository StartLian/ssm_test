package com.gessica.arithmetic.string;

import java.util.Scanner;

/**
 * 最长公共字符串
 * @author 廉吉鹏
 * @date2020年11月6日下午9:03:30
 * TODO
 */
public class LongestString {

	public static void main(String[] args) {
//			"1AB2345CD","12345EF"
		    String str1 = "1AB2345CD";
//		    String str1 = sc.nextLine();
		    System.out.println("str1:"+str1);
		    String str2 = "12345EF";
//		    String str2 = sc.nextLine();
		    System.out.println("str2:"+str2);
		    String r = LCS(str1, str2);
		    System.out.println(r);
		
	}
	public static String LCS(String str1, String str2){
		if(str1.length() == 0 || str2.length() == 0){
		    return "-1";
		}
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		int endIndex = -1;
		int max = 0;
		                                                                       
		int[][] arr = new int[s1.length][s2.length];
		for (int i = 0; i < s1.length; i++) {
		    for (int j = 0; j < s2.length; j++) {
		        if(i==0 || j==0) {
		            arr[i][j] = s1[i] == s2[j] ? 1: 0;
		        } else {
		            if(s1[i] == s2[j]) {
		                arr[i][j] = arr[i-1] [j-1] + 1;
		            }
		 
		        }
		        if(arr[i][j] > max) {
		            max = arr[i][j];
		            endIndex = i;
		        }
		        // System.out.print(arr[i][j]+ " ");
		    }
		    // System.out.println();
		}
		 
		return endIndex==-1 ? "-1" : str1.substring(endIndex-max+1, endIndex+1);
	}
	public static String LCS_2(String str1, String str2){
		if (str1.length() == 0 || str2.length() ==0) {
			return "-1";
		}
		int  max =0;
		int endIndex = -1;
		char[] charArray1 = str1.toCharArray();//ADBFRG
		char[] charArray2 = str2.toCharArray();//ACFDBFRG
		int[][] arr = new int[charArray1.length][charArray2.length];
		for (int i = 0; i < charArray1.length; i++) {
			for (int j = 0; j < charArray2.length; j++) {
				if (i == 0 || j==0) {
					arr[i][j] = charArray1[i]==charArray2[j] ? 1:0;
				}else {
					if (charArray1[i]==charArray2[j] ) {
						arr[i][j] = arr[i-1][j-1]+1;
					}
				}
				if (arr[i][j]>max) {
					max = arr[i][j];
					endIndex = i;
				}
			}
		}
		return endIndex==-1 ? "-1" : str1.substring(endIndex-max+1, endIndex+1);
	}
}
