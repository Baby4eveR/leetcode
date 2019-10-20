package leetcode_203_RemoveLinkedListElements;
//
public class Solution {
	public static ListNode deleteNode(ListNode head,int val) {
       if(null == head ) {
    	   return null;
       }
       ListNode pre = new ListNode(0);
       pre.next = head;
       ListNode cur = head;
       while(cur!=null) {
    	 if(cur.val == val) {
    		 pre.next = cur.next;
    		 cur = cur.next;
    	 }else {
    		 
    		 pre = pre.next;
    		 cur = cur.next;
    	 } 
       
       
       }
       return head;
    }
      
}
