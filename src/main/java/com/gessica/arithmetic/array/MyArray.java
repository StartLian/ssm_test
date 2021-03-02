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
		System.out.println("maxLength:"+maxLength );
		int[] twoSum = myArray.twoSum(a, 6);
		System.out.println(twoSum[1]+" :"+twoSum[0]);
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
    public int maxLength2 (int[] arr) {
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
    public int maxLength (int[] arr) {
        // write code here
        int res = 0, left = -1;
     //用来存放窗口存放过的数字
     HashMap<Integer, Integer> windows = new HashMap<>();
     //窗口不断往右移
     for(int right = 0; right < arr.length; right++){
         //根据题目，当遇到重复的数字时，缩小左侧窗口
         if( windows.containsKey(arr[right])){
             //因为我们有可能遇到索引比left原来还小的相同数字
             //所以这里要进行比较，目的还是为了缩小左侧窗口，确保窗口内全是不重复的数字
             left = Math.max(left, windows.get(arr[right]));
         }
         //更新窗口内数字的索引
         windows.put(arr[right], right);
         //right-left是窗口大小
         //因为要找最长，所以要进行比较
         res = Math.max(res, right-left);
  
     }
     return res;
    }
	/**
	 * https://www.nowcoder.com/practice/7cd13986c79d4d3a8d928d490db5d707?tpId=188&&tqId=36898&rp=1&ru=/ta/job-code-high-week&qru=/ta/job-code-high-week/question-ranking
	 * 给出一个转动过的有序数组，你事先不知道该数组转动了多少
(例如,0 1 2 4 5 6 7可能变为4 5 6 7 0 1 2).
在数组中搜索给出的目标值，如果能在数组中找到，返回它的索引，否则返回-1。
假设数组中不存在重复项。
	 * @author wanji
	 * @data 2020年12月28日下午5:31:10
	 * @des @param arr
	 * @des @param target
	 * @des @return
	 */
	public int search (int[] arr,int target) {
        // write code here
        int left = 0,right= arr.length-1;
        while(left<=right) {
        	int mid = left+(right-left)/2;
        	if (arr[mid]==target) {
				return mid;
			}
        	if (arr[mid]>=arr[left]) {
				if (arr[mid]>target && target>=arr[left]) {
					right =  mid -1;
				}else {
					left = mid +1;
				}
			}else {
				if (arr[mid]<target && target <= arr[right]) {
					left =mid +1;
				}else {
					right =mid-1;
				}
			}
        }
    	return -1;
    }
	/**
	 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

你可以按任意顺序返回答案。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * @2021年1月5日上午9:54:26
	 * @param @param nums
	 * @param @param target
	 * @param @return 参数
	 * @return int[] 返回类型
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		 int[] resList = new int[2];
		HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
		for(int i = 0; i<nums.length;i++) {
			int a =(target - nums[i]);
			if (hashMap.containsKey(a)) {
				Integer integer = hashMap.get(a);
				resList[0]=integer; 
	       		resList[1]=i; 
	       		return resList;
			}
			hashMap.put(nums[i], i);
		}
       return resList;
       
   }
}
