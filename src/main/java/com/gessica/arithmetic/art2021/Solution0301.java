package com.gessica.arithmetic.art2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import com.gessica.arithmetic.solution.ListNode;

/**
 * 三月份第一篇
 * 1.冒泡排序
 * 2.倒序字符串
 * 3.两个栈实现队列
 * @author wanji
 * @2021年3月1日上午8:54:49
 */
public class Solution0301 {
	public static void main(String[] args) {
		/*int[] a=   {10,7,7,11,8,5,6,4,2,3,1};
		BubbleSort(a);*/
		
//		String my_name____is__dd = changeStr("my_name____is__dd");
		
//		 int[] nums = {4,5,1,6,2,7,3,8};
//	        GetLeastNumbers(nums,8);
		
//        setvalue(1);
//        setvalue(3);
//        System.out.printf(" "+getValue());
//        setvalue(2);
//        System.out.printf(" "+getValue());
//        setvalue(5);
//        setvalue(1);
//        System.out.printf(" "+getValue());
//        System.out.printf(" "+getValue());
		
		int[] a= {2,4};
		int[] b= {1,2,4,5,6};
		megerArrays(a, 2, b,5);
	}
	/**
	 * //		输入：“my_name____is__dd”
//		输出：“dd_is____name__my” 
 * //	[d, d][_][i, s][_, _, _, _][n, a, m, e][_, _][m, y]
	 * @2021年3月1日上午9:23:24
	 * @param @param srcStr
	 * @param @return 参数
	 * @return String 返回类型
	 * @param srcStr
	 * @return
	 */
	public static String changeStr(String srcStr) {
		char[] chars = srcStr.toCharArray();
		int len = chars.length;
		ArrayList<String> list1 = new ArrayList<>();//存字符
		ArrayList<String> list2 = new ArrayList<>();//存_
		ArrayList<Character> list3 = new ArrayList<>();//
		for (int i = 0;i<len;i++){

			if (list3.size() != 0 && (list3.get(list3.size()-1) == '_' && chars[i] != '_')){//来字母了
				String tempStr = list3.toString();
				if (list3.get(0) == '_'){
					list2.add(tempStr);
				}else {
					list1.add(tempStr);
				}
				list3.clear();
			}else if (list3.size() != 0 && (list3.get(list3.size()-1) != '_' && chars[i] == '_')){//来——了
				String tempStr = list3.toString();
				if (list3.get(0) == '_'){
					list2.add(tempStr);
				}else {
					list1.add(tempStr);
				}
				list3.clear();
			}
			list3.add(chars[i]);
			if (i == len-1){
				String tempStr = list3.toString();
				if (list3.get(0) == '_'){
					list2.add(tempStr);
				}else {
					list1.add(tempStr);
				}
				list3.clear();
			}
		}
		StringBuffer sb = new StringBuffer();
		int index = 0;
		for (int k = list1.size()-1;k>=0;k-- ) {
			sb.append(list1.get(k));
			if ((index+1)<=list2.size()){
				sb.append(list2.get(index++));
			}
		}
		return sb.toString();
	}
	/**
	 * 冒泡排序
	 * @2021年3月1日上午9:44:07
	 * @param @param src 参数
	 * @return void 返回类型
	 * @param src
	 */
	public static void BubbleSort(int[] src){
		int len = src.length;
		int temp;
		//自己的
		for (int i = 0;i<len;i++){
			for (int  j=i+1;j<len;j++){
				if(src[i]>src[j]){
					temp = src[i];
					src[i] = src[j];
					src[j] = temp;
				}
			}
		}
		System.out.println("src = " + Arrays.toString(src));
		//网上的,这个应该是冒泡
		for (int j = 0; j < len - 1; j++){
			for (int i = 0; i < len - 1 - j; i++)
				if (src[i] > src[i + 1]){
					temp = src[i];
					src[i] = src[i + 1];
					src[i + 1] = temp;
				}
		}
		System.out.println("src = " + Arrays.toString(src));
	}
	/**
	 * 通过先构建大顶堆，在进行堆排序，找出最小K个数
	 * @2021年3月2日下午8:11:08
	 * @param @param src
	 * @param @param k 参数
	 * @return void 返回类型
	 * @param src
	 * @param k
	 */
	 public static void  GetLeastNumbers(int[] src, int k){
	        //构建长度K的大顶堆
	        int[] res = new int[k];
	        //1.将输入数组的前k个数放入结果数组，作为初始的k个数
	        for (int i = 0;i<k;i++){
	            res[i] = src[i];
	        }
	      //2.将结果数据构建成大根堆
	        buildMaxHeap(res,k);
	        for (int i = 0; i <  res.length; i++) {
	            System.out.println("result ："+res[i]+" ");
	        }
	        //调整大顶堆，达到获取最小k 个数
	      //3.遍历输入数组,每个数都与大根堆的根节点比较
	        for (int i = k ;i<src.length;i++){
	            if (src[i]<res[0]){
	                res[0] = src[i];
	                //4.重构大根堆
	                buildMaxHeap(res,k);
	            }
	        }
	        for (int i = 0; i <  res.length; i++) {
	            System.out.println("result2 ："+res[i]+" ");
	        }
	        //调整为小顶堆
	        // 5.调整大根堆，即堆排序
	        for(int i= res.length-1;i>=1;i--){
	            swap(res,i,0); // 将当前最大的数（w为0）放置到未排序数组的末尾
	            buildMaxHeap(res,i);
	        }
	        for (int i = 0; i <  res.length; i++) {
	            System.out.println("result3 ："+res[i]+" ");
	        }
	    }

	    private static void buildMaxHeap(int[] res, int len) {
	        for (int i = len/2-1;i>=0;i--){ //len/2-1最右下侧，父节点
	           just(res,len,i);
	        }
	    }

	    private static void just(int[] res, int len, int index) {
	        int left = index*2+1;
	        int right = index*2+2;
	        if (left <= len-1 && res[left]>res[index]){
	            swap(res,left,index);
	        }
	        if (right<=len-1 && res[right]>res[index]){
	            swap(res,right,index);
	        }
	    }

	    private static void swap(int[] res, int left, int index) {
	        int temp = res[left];
	        res[left] = res[index];
	        res[index] = temp;
	    }
	    /**
	     * 两个栈实现队列
	     */
	    private static Stack pushState = new Stack<Integer>();
	    private static Stack pullState = new Stack<Integer>();
	    public static  void setvalue(int value){
	        pushState.push(value);
	    }
	    public static Integer getValue(){
	        if (pullState.empty()){
	            while(!pushState.empty()){
	                Integer tempValue = (Integer) pushState.pop();
//	                System.out.printf("tempValue:"+tempValue);
	                pullState.push(tempValue);
	            }
	        }
	        return (Integer) pullState.pop();
	    }
	  public ListNode reverseList(ListNode head) {
		  ListNode pre =null;
		  ListNode next = null;
		  while(head != null) {
			  next = head.next;
			  
			  head.next = pre;
			  
			  pre =head;
			  
			  head =next;
		  }
		  return pre;
		  
	  }
	  /**
	   * 反转链表
	   * @2021年3月9日下午1:39:32
	   * @param @param head
	   * @param @return 参数
	   * @return ListNode 返回类型
	   * @param head
	   * @return
	   */
	  public ListNode ReverseList(ListNode head) {
	        ListNode pre =null;
	        ListNode next =null;
	        while(head !=null){
	            //记录下一个接点
	            next = head.next;
	            //将head的下一个节点指向null
	            head.next = pre;
	            //当前节点指向带反转的节点
	            pre = head;
	            //head指向下一个节点
	            head = next;
	        }
	        return pre;
	    }
	  /**
	   * 移除链表指定节点
	   * @2021年3月26日上午9:08:16
	   * @param @param head
	   * @param @param value
	   * @param @return 参数
	   * @return ListNode 返回类型
	   * @param head
	   * @param value
	   * @return
	   */
	  public ListNode RemoveTheValue(ListNode head,int value) {
		  Stack<ListNode> stack = new Stack();
		  while(head != null) {
 			  if (head.val != value) {
				  stack.push(head);
			 }
			  head =head.next;
		  }
		  while(!stack.isEmpty()) {
			  stack.peek().next = head; //重点
			  head.next =  stack.pop();
		  }
		  
		  return head;
	  }
	  /**
	   * 合并两个有序数组
	   * @2021年3月26日上午9:15:05
	   * @param @param arr1
	   * @param @param len1
	   * @param @param arr2
	   * @param @param len2
	   * @param @return 参数
	   * @return int[] 返回类型
	   * @param arr1
	   * @param len1
	   * @param arr2
	   * @param len2
	   * @return
	   */
	  public static int[] megerArrays(int[] arr1,int p1,int[] arr2,int p2) {
		  int[] target = new int[p2+p1];
		  int temp = target.length-1;
		  int len1 = p1-1;
		  int len2 = p2-1;
		  while(len1>=0 && len2>=0) {
			  target[temp--] = arr1[len1]>arr2[len2] ? arr1[len1--] : arr2[len2--];
		  }
		  if (len1>=0) {
			  System.arraycopy(arr1, 0, target, 0, len1+1);
		  }else {
			  System.arraycopy(arr2, 0, target, 0, len2+1);
		  }
		  for (int i =0;i<target.length;i++) {
			System.out.print(target[i]+",");
		}
		  return target;
	  }
	    
}
