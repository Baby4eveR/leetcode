package leetcode_19_RemoveNthNodeFromEndofList;
//删除链表的倒数第k个节点
//删除链表节点和找到链表倒数第k个节点的综合

public class Solution {
	  public ListNode removeNthFromEnd(ListNode head, int n) {
		  	if (null == head) {
		  		return null;
		  	}
	        ListNode root = new ListNode(0);
	        root.next = head;
	        ListNode cur = head;
	        ListNode pre = root;
	        
	        for(int count = 0;count < n-1;count ++) {
	        	cur = cur.next;
	        }
	        while(cur.next != null) {
	        	cur = cur.next;
	        	pre  = pre.next;
	        	
	        }
	        pre.next = pre.next.next;
	        return root.next;
	    }
}
