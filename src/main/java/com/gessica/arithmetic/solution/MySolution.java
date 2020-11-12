package com.gessica.arithmetic.solution;

public class MySolution {

	public static void main(String[] args) {
		int[] b= {1,2,2,4,5,6};
		int[] a= {1,2,2,4,5,6};
		MySolution solution = new MySolution();
//		solution.merge(a, 6, b,6);
		int index = solution.upper_bound_(6,2,b);
		System.out.println("index:"+index);
	}
	/**
	 * 链表中是否存在环
	 * 通过一个快指针，一次走两步，一个慢指针，一次走一步，总能相遇。链表相交处
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
		ListNode p = head;
		ListNode q = head;
		while (p !=null & p.next !=null) {
			p = p.next.next;
			q = q.next;
			if (p == q) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 二分查找
	 * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。 
	 * @param n
	 * @param v
	 * @param a
	 * @return124678
	 */
	public int upper_bound_ (int len, int targer, int[] a) {
		int l= 0;
		int h= len-1;
		while (l<=h) {
			int mid = (l+h)/2;
			if (mid>0&&targer<=a[mid-1]) {//在左边
				h=mid-1;
			}else if (targer>a[mid]) {//在右边
				l=mid+1;
			}else {
				return mid;
			}
		}
		return len+1;
		
	}
	/**
	 * 二分查找
	 * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。 
	 * @param n
	 * @param v
	 * @param a
	 * @return124678
	 */
	public int upper_bound_2 (int len, int targer, int[] a) {
		int l= 0;
		int h= len-1;
		while (l<=h) {
			int mid = (l+h)/2;
			if (targer<a[mid]) {//在左边
				h=mid-1;
			}
			if (targer>a[mid]) {//在右边
				l=mid+1;
			}
			if (targer==a[mid]) {
				return mid;
			}
		}
		return len+1;
		
	}
	
	/**
	 * 链表中倒数K节点
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode FindKthToTail(ListNode head,int k) {
		ListNode fast = head;
		ListNode slow = head;
		for (int i = 0; i < k; i++) {
			if (head == null) {
				return null;
			}
			fast = fast.next;
		}
		while (fast.next !=null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
	/**
	 * 合并两个有序数组
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		
		int t1 =  m-1;
		int t2 = n-1;
		int t = n+m-1;
		int[] temp = new int[t+1];
		while((t1>=0)&&(t2>=0)){
			temp[t--] = nums1[t1]>nums2[t2] ? nums1[t1--]:nums2[t2--];
		}
		if (t2-t1>0) {
			System.arraycopy(nums2, 0, temp, 0, t2+1);
		}else if (t2-t1<0){
			System.arraycopy(nums1, 0, temp, 0, t1+1);
		}
		for (int i : temp) {
			System.out.print(i+" ");
			
		}
	}
	/**
	 * 反转链表
	 * @param agrs
	 */
	public ListNode ReverseList(ListNode head) {
		ListNode p = null;
		ListNode pre = null;
		while (head != null) {
			p =head.next;
			head.next = pre;
			pre =head;
			head =p;
		}
		return pre;
	}
}
