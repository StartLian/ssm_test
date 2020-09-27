package com.gessica.arithmetic.solution;
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
	/*public ListNode ReverseList(ListNode head) {
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
    }*/
	public static void main(String[] agrs) {
		int[] a= {2,4,0,0,0,0,0};
		int[] b= {1,5,6,8,9};
		Solution solution = new Solution();
		solution.merge(a, 2, b,5);
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
}
