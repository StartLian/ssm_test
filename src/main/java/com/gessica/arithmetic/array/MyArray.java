package com.gessica.arithmetic.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * int数组，不重复的三个数求和
 * @author wanji
 * @2020年10月26日上午11:04:02
 */
public class MyArray {
	public static void main(String[] agrs) {
		MyArray myArray = new MyArray();
		int[] a = {-10, 0 ,10 ,20 ,-10, -40};
		ArrayList<ArrayList<Integer>> threeSum =myArray.threeSum(a);
		System.out.println(threeSum.toString());
	}
	
	
	/**
	 * @2020年10月26日上午11:05:57
	 * @param @param num
	 * @param @return 参数
	 * @return ArrayList<ArrayList<Integer>> 返回类型
	 * @param num
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer> > res = new ArrayList<>();
        if (num.length < 3) return res;
        for (int i = 0; i < num.length - 2; ++i) {
            int j = i + 1;
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
                    while (j + 1 < k && num[j+1] == num[j]) ++j;  // 防止重复
                    while (k - 1 > j && num[k-1] == num[k]) --k;  // 防止重复
                    ++j; --k;
                }
            }
            while (i + 1 < num.length - 2 && num[i+1] == num[i]) ++i;   // 防止重复
        }
        return res;
    }
}
