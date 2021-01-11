package com.gessica.arithmetic.tree20_09;

public class AddTwoSum {
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	 /**
	  * https://leetcode-cn.com/problems/add-two-numbers/solution/zhi-zhen-lian-biao-jian-dan-yi-li-jie-on-by-guai-m/
	  * @2021年1月6日上午11:26:04
	  * @param @param l1
	  * @param @param l2
	  * @param @return 参数
	  * @return ListNode 返回类型
	  * @param l1
	  * @param l2
	  * @return
	  */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode pre = new ListNode(0);
        ListNode listNode = pre;
		int t=0;
		int p=0;
		while(l1 != null || l2 != null) {
			int v1=0;
			int v2=0;
			
			if (l1 != null) {
              v1=l1.val;
				l1=l1.next;
			}
			
			if (l2 != null) {
              v2=l2.val;
				l2=l2.next;
			}
			p = (t + v1+ v2)%10;
			t = (t + v1+ v2)/10;
			listNode.next=new ListNode(p);
            listNode = listNode.next;
		}
      if (t>0) {
			listNode.next=new ListNode(t);
		}
		return pre.next;
  }
}
