package com.gessica.arithmetic.art2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/**
 * 20210220
 * @author wanji
 * @2021年2月20日上午9:35:02
 * 1.快排
 * 2.遍历二叉树
 */
public class Solution0201 {

	public static void main(String[] args) {
		   /*
		    * int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};

	        qkSort(arr, 0, arr.length-1);//arr.length-1重点

	        
	        for (int i = 0; i < arr.length; i++) {

	            System.out.print(arr[i]+" ");

	        }*/
	/*	LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(7);
		linkedList.add(5);
		TestTreeNode creatTree = creatTree(linkedList);
//		preOrder(creatTree);
		preOrderStack(creatTree);*/
	/*	int[] temp= {2,5,8,7,9,3,4};
		List<Integer> searchtarget = searchtarget(temp, 9);
		System.out.println(searchtarget.get(0)+ " "+searchtarget.get(1));*/
		
		/*int[] temp= {6,7,0,1,2,3};
		int searchtarget2 = searchtarget2(temp,3);
		System.out.println("searchtarget2: "+searchtarget2);*/
		/*int[] temp= {6,7,0,1,1,2,3};
		int a = searchLongst(temp);
		System.out.println("a:"+a);*/
		int[] num = {-10, 0 ,10 ,20 ,-20 ,-10 ,-40};
		ArrayList<ArrayList<Integer>> threeSum = threeSum(num);
		System.out.println(threeSum.toString());
	}
	/**
	 * 快排
	 * https://blog.csdn.net/shujuelin/article/details/82423852
	 * @2021年2月20日上午10:22:13
	 * @param @param strarr
	 * @param @param start
	 * @param @param end 参数
	 * @return void 返回类型
	 * @param strarr
	 * @param start
	 * @param end
	 */
	public static void  qkSort(int[] strarr,int start,int end) {
		int low =start;
		int high =end;
		//一定要有递归退出条件
		if (low>high) {
			return;
		}
		int target = strarr[start];
		int t;
		
		while(low<high) {
			//先右边
			while(target<=strarr[high] && low<high) {
				--high;
			}
			while(target>=strarr[low] && low<high) {
				++low;
			}
			if (low<high) {
				//高低交换
				t = strarr[high];
				strarr[high] =strarr[low];
				strarr[low] =t;
			}
		}
		//target交换
		strarr[start] = strarr[low];
		strarr[low] = target;
		//先左边
		qkSort(strarr,start,high-1);
		qkSort(strarr,high+1,end);
	}
	/**************************************遍历二叉树*****************************************/
	public class TestTreeNode {

		TestTreeNode left;
		TestTreeNode right;
		int data;
		public TestTreeNode(int data) {
			this.data =data;
			
		}
	}
	
	public static TestTreeNode creatTree(LinkedList<Integer> ll) {
		TestTreeNode treeNode = null;
		if (ll.isEmpty()) {
			return null;
		}
		Integer data = ll.poll();
		if (data != 0) {
			treeNode = new Solution0201().new TestTreeNode(data);
			treeNode.left = creatTree(ll);
			treeNode.right = creatTree(ll);
		}
		return treeNode;
	}
	//前序遍历
	public static void preOrder(TestTreeNode treeNode) {
		if (treeNode  != null) {
			int teemp = treeNode.data;
			System.out.print(teemp+" ");
			if (treeNode.left != null) {
				preOrder(treeNode.left);
			}
			if (treeNode.right != null) {
				preOrder(treeNode.right);
			}
		}
		System.out.println(" ");
	}
	//中序遍历
	public static void midOrder(TestTreeNode treeNode) {
		if (treeNode  != null) {
			if (treeNode.left != null) {
				preOrder(treeNode.left);
			}
			int teemp = treeNode.data;
			System.out.print(teemp+" ");
			if (treeNode.right != null) {
				preOrder(treeNode.right);
			}
		}
	}
	//后序遍历
	public static void afterOrder(TestTreeNode treeNode) {
		if (treeNode  != null) {
			if (treeNode.left != null) {
				preOrder(treeNode.left);
			}
			if (treeNode.right != null) {
				preOrder(treeNode.right);
			}
			int teemp = treeNode.data;
			System.out.println(teemp+" ");
		}
	}
	//层级遍历
	 public static void laverOrder(TestTreeNode treeNode) {
		LinkedList<TestTreeNode> ll = new LinkedList<TestTreeNode>();
		ll.add(treeNode);
		while(!ll.isEmpty()) {
			TestTreeNode temp = ll.poll();
			System.out.println(temp.data);
			if (temp.left!= null) {
				ll.add(temp.left);
			}
			if (temp.right!= null) {
				ll.add(temp.right);
			}
		} 
	}
	//深度
	public static int deep(TestTreeNode treeNode) {
		if (treeNode != null) {
			int l = deep(treeNode.left);
			int r = deep(treeNode.right);
			if (l>r) {
				return l+1;
			}else {
				return r+1;
			}
		}
		return 0;
	}
	//前序非递归遍历
	public static void preOrderStack(TestTreeNode treeNode) {
		Stack<TestTreeNode> stack = new Stack<TestTreeNode>();
		TestTreeNode Node = treeNode;
		while(Node != null || !stack.isEmpty()) {
			while(Node != null) {
				System.out.print(Node.data +" ");
				stack.push(treeNode);
				Node = Node.left;
			}
			if (!stack.isEmpty()) {
				Node = stack.pop();
				Node = Node.right;
			}
		}
		System.out.println(" ");
	}
	//中序非递归遍历
	public static void midOrderStack(TestTreeNode treeNode) {
		Stack<TestTreeNode> stack = new Stack<TestTreeNode>();
		TestTreeNode Node = treeNode;
		while(Node != null || !stack.isEmpty()) {
			while(Node != null) {
				stack.push(treeNode);
				Node = Node.left;
			}
			if (!stack.isEmpty()) {
				Node = stack.pop();
				System.out.print(Node.data +" ");
				Node = Node.right;
			}
		}
		System.out.println(" ");
	}
	/**
	 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
	 * 
	 * @2021年2月23日上午9:42:24
	 * @param @param nums
	 * @param @param target
	 * @param @return 参数
	 * @return List<Integer> 返回类型
	 * @param nums
	 * @param target
	 * @return
	 */
	public static List<Integer> searchtarget(int[] nums,int target){
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0;i<nums.length;i++) {
			int temp = target - nums[i];
			if (map.containsKey(temp)) {
				list.add(i);
				list.add(map.get(temp));
				return list;
			}
			map.put(nums[i], i);
		}
		return list;
	}
	/**
	 * 给出一个转动过的有序数组，你事先不知道该数组转动了多少
(例如,0 1 2 4 5 6 7可能变为4 5 6 7 0 1 2).
在数组中搜索给出的目标值，如果能在数组中找到，返回它的索引，否则返回-1。
假设数组中不存在重复项。
	 * @2021年2月23日上午10:24:03
	 * @param @param nums
	 * @param @param target
	 * @param @return 参数
	 * @return int 返回类型
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int searchtarget2(int[] nums,int target) {
		int left =0;
		int right = nums.length-1;
		while(left<=right) {
			int mid = left+(right-left)/2;
			if (nums[mid] == target) {
				return nums[mid];
			}
			if (nums[mid]>=nums[left]) {//左边有序
				if (target>=nums[left] && target<nums[mid]) {
					right=mid-1;
				}else {
					left = mid+1;
				}
			}else {
				if (target>nums[mid] && target<=nums[right]) {
					left = mid +1 ;
				}else {
					right = mid -1;
				}
			}
		}
		return -1;
	}
	/**
	 * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
	 * @2021年2月24日上午9:19:19
	 * @param @param nums
	 * @param @return 参数
	 * @return int 返回类型
	 * @param nums
	 * @return
	 */
	public static int searchLongst(int[] nums) {
		HashMap hashMap = new HashMap<Integer,Integer>();
		int left = -1;//****
		Integer max = 0;
		for(int i = 0;i<nums.length;i++) {
			if (hashMap.containsKey(nums[i])) {
				left =  Math.max(left,(int) hashMap.get(nums[i]));//****
			}
			max = (i-left)>max ? (i-left) : max;
			hashMap.put(nums[i], i);
		}
		return max;
	}
	/**
	 * 
	 * @2021年2月25日上午9:11:28
	 * @param @param num
	 * @param @return 参数
	 * @return ArrayList<ArrayList<Integer>> 返回类型
	 * @param num
	 * {-10, 0 ,10 ,10,20 ,-10, -40, -30};
	 * {-10, 0 ,10 ,20 ,-20 ,-10 ,-40};
	 * -40,-20,-10,-10,0,10,20,
	 * 数组中相加和为0的三元组
	 * @return
	 */
	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int index = num.length;
		for(int i = 0;i<index;i++) {
			int target =-num[i];
			int j = i+1;
			int k = index  - 1;
			while(j < k) {
				if (target>(num[j]+num[k])) {
					j++;
				}else if (target<(num[j]+num[k])) {
					k--;
				}else {
					ArrayList<Integer> list1 = new ArrayList<Integer>();
					list1.add(num[i]);
					list1.add(num[k]);
					list1.add(num[j]);
					res.add(list1);

					while(j+1<k&& (num[j] == num[j+1])) {
						j++;
					}
					while(j<k-1&& (num[k] == num[k-1])) {
						k--;
					}
					j++;
					k--;
				}
				
				
			}
			while(i+1<k-2 && num[i] == num[i+1]) {i++;};
		}
		return res;
		
	}
}
