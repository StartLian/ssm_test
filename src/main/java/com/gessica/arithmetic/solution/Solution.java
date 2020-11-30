package com.gessica.arithmetic.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 反转链表
 * @author wanji
 *
 */
public  class Solution {
	/**
	 * 反转链表
	 * @param agrs
	 */
	public ListNode ReverseList(ListNode head) {
        //初始化pre指针，用于记录当前结点的前一个结点地址
        ListNode pre = null;
        //初始化p指针，用于记录当前结点的下一个结点地址
        ListNode p = null;
        //head指向null时，循环终止。
        while(head != null){
            //先用p指针记录当前结点的下一个结点地址。
            p = head.next;
            //让被当前结点与链表断开并指向前一个结点pre。
            head.next = pre;
            //pre指针指向当前结点
            pre = head;
            //head指向p(保存着原链表中head的下一个结点地址)
            head = p;
        }
        return pre;//当循环结束时,pre所指的就是反转链表的头结点
    }
	/**
	 * 移除链表中指定值
	 * @param head
	 * @param val
	 * @return
	 */
	public static ListNode removeTheVal(ListNode head,int val) {
		if (head == null) {
			return null;
		}
		Stack<ListNode> stack = new Stack<ListNode>();
		while (head != null) {
			if (head.val != val) {
				stack.push(head);
			}
			head = head.next;
		}
		while (!stack.isEmpty()) {
			stack.peek().next = head;
			head= stack.pop();
		}
		return head;
	}
	/**
	 * 构建链表
	 * @param list
	 * @return
	 */
	public static ListNode creatListNode(LinkedList<Integer> list) {
		ListNode listNode =null;
		while (!list.isEmpty()) {
			Integer integer = list.pollFirst();
			listNode=new ListNode(integer);
			listNode.next =  creatListNode(list);
		}
		return listNode;
	}
	public static void main(String[] agrs) {
//		int[] a= {2,4,0,0,0,0,0};
//		int[] b= {1,2,4,5,6};
//		Solution solution = new Solution();
//		solution.merge(a, 2, b,5);
//		int upper_bound_ = solution.upper_bound_(5,3,b);
//		System.out.println("upper_bound_:"+upper_bound_);
		//
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		ListNode listNode = creatListNode(linkedList);
		removeTheVal(listNode,2);
	}
	
	/**
	 * 合并两个有序数组
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
	    // two get pointers for nums1 and nums2
	    int p1 = m - 1;
	    int p2 = n - 1;
	    // set pointer for nums1
	    int p = m + n - 1;

	    // while there are still elements to compare
	    while ((p1 >= 0) && (p2 >= 0))
	      // compare two elements from nums1 and nums2 
	      // and add the largest one in nums1 
	      nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

	    // add missing elements from nums2
	    System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
	    for(int i=0;i<=(m + n - 1);i++){
			System.out.print(" "+nums1[i]);
		}
	  }
	/**
	 * 链表中倒数K节点
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k ==0 ){
            return null;
        }
 
        ListNode slow=head;
        ListNode fast=head;
        //先通过fast拿到K指针的长度域
        for(int i=0;i<k;i++){
            if(fast==null){
                return null;
            }
            fast=fast.next;
 
        }
        //一块平移得，当fast到最后，slow就是k
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
 
        return slow;     
	}
	/**
	 * 二分查找
	 * 输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。 
	 * @param n
	 * @param v
	 * @param a
	 * @return
	 */
	public int upper_bound_ (int len, int targer, int[] a) {
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
	 * 链表中是否存在环
	 * 通过一个快指针，一次走两步，一个慢指针，一次走一步，总能相遇。链表相交处
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode p = head;
        ListNode q = head;
        while(p!=null && p.next!=null){
            p = p.next.next;
            q = q.next;
            if(p==q){
            	
                return true;
            }
 
        }
        return false;
    }
	/**
	 * 倒序打印链表
	 * @2020年11月30日下午6:45:33
	 * @param @param listNode
	 * @param @return 参数
	 * @return ArrayList<Integer> 返回类型
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> list = new ArrayList<Integer>();
        Stack<ListNode> stack = new Stack<ListNode>();
        while(listNode != null) {
        	stack.push(listNode);
        	listNode=listNode.next;
        }
        while(!stack.isEmpty()) {
        	list.add(stack.pop().val);
        }
        return list;
    }
	/**
	 * 链表中环的大小
	 * @param head
	 * @return
	 */
	public int hasCycleSize(ListNode head) {
		int index = 0;
		if(head == null){
			return 0;
		}
		ListNode p = head;
		ListNode q = head;
		while(p!=null && p.next!=null){
			p = p.next.next;
			q = q.next;
			if(p==q){
				while(q!=null){
					q = q.next;
					++index ;
					if(p==q){
						return index;
					}
				}
			}
		}
		return 0;
	}
}
