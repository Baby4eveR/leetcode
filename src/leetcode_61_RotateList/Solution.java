package leetcode_61_RotateList;
//链表向右旋转k步，
//先连成环，再找到k的位置，打断链表
//注意k值可以很大

public class Solution {
		public ListNode rotateRight(ListNode head, int k) {
	        if(head == null || head.next == null || k == 0 ) {
	        	return head;
	        }
	        ListNode start = head;
			int len =1;
			while(head.next != null) {
				head = head.next;
				len++;
			}
			
			head.next = start;
			k = k % len;
			
			for(int i=0; i<len - k-1 ;i++) {
				start = start.next;
				
			}
			
			ListNode temp = start.next;
			start.next = null;
			return temp;
	    }
}
