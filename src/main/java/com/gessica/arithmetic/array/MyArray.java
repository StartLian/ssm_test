package com.gessica.arithmetic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/**
 * int数组，不重复的三个数求和
 * @author wanji
 * @2020年10月26日上午11:04:02
 */
public class MyArray {
	public static void main(String[] agrs) {
		MyArray myArray = new MyArray();
//		int[] a = {-10, 0 ,10 ,10,20 ,-10, -40, -40};
//		ArrayList<ArrayList<Integer>> threeSum =myArray.threeSum(a);
//		System.out.println(threeSum.toString());
		///*********************
		int[] a = {1,2,3,4,2,5,6,8,9,3};
		int maxLength = myArray.maxLength(a);
		System.out.println("maxLength:"+maxLength);
	}
	
	
	/**
	 * @2020年10月26日上午11:05:57
	 * @param @param num
	 * @param @return 参数
	 * @return ArrayList<ArrayList<Integer>> 返回类型
	 * @param num
	 * @return
	 * {-10, 0 ,10 ,10,20 ,-10, -40, -40};
	 * -40,-40,-10,-10,0,10,10,20
	 */
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        if (num.length < 3) return res;
        for (int i = 0; i < num.length - 2; ++i) {
            int j = i + 1;//初值：1
            System.out.println("j:"+j+" i:"+i);
            //最大索引
            int k = num.length - 1;
            int target = -num[i];
            while (j < k) {
                if (num[j] + num[k] > target) --k;
                else if (num[j] + num[k] < target) ++j;
                else {
                    ArrayList<Integer> current =new ArrayList<>() ;
                    		List<Integer> asList = Arrays.asList(num[i], num[j], num[k]);
                    		current.addAll(asList);
                    res.add(current);
                    System.out.println("j:"+j+" k:"+k);
                    while (j + 1 < k && num[j+1] == num[j]) ++j;  // 防止重复
                    while (k - 1 > j && num[k-1] == num[k]) --k;  // 防止重复
                    System.out.println("j:"+j+" k:"+k);
                    ++j; --k;
                }
            }
            while (i + 1 < num.length - 2 && num[i+1] == num[i]) ++i;   // 防止重复
        }
        return res;
    }
	 /**
     * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        // write code here
        int max = 0 ,left =0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
			if (hashMap.containsKey(arr[i])) {
				//获取重复数字的最右侧位置,
				left = Math.max(left, hashMap.get(arr[i]));
			}
			hashMap.put(arr[i], i);
			max = Math.max(i-left, max);
		}
    	return max;
    }
}
