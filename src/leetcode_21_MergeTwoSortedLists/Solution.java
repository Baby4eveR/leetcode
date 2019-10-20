package leetcode_21_MergeTwoSortedLists;
//合并有序链表


public class Solution {
	//非递归版
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
        	return l2;
        }
        if(l2 == null) {
        	return l1;
        }
        
        ListNode phead = new ListNode(0);
        ListNode temp = phead;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        
        while(cur1!=null && cur2 != null) {
        	if(cur1.val < cur2.val) {
        		phead.next = cur1;
        		cur1 = cur1.next;
        		phead =phead.next;
        	}else {
        		phead.next = cur2;
        		cur2 = cur2.next;
        		phead =phead.next;
        	}
        }
        if(cur1 == null) {
        	while(cur2 != null) {
        		phead.next = cur2;
        		phead = phead.next;
        		cur2 = cur2.next;
        	}
        }
        if(cur2 == null) {
        	while(cur1 != null) {
        		phead.next = cur1;
        		phead = phead.next; //注意phead也要指向下一个，这句不能丢
        		cur1 = cur1.next;
        	}
        
        }
        return temp.next;
    }
	//递归版(这个就是在递进的过程中处理子问题，链表反转那个递归属于在归的过程中处理子问题)
	public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		if(l1 == null ) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}
		
		ListNode newhead = null;
		
		if(l1.val < l2.val) {
			newhead = l1;
			newhead.next = mergeTwoLists(l1.next,l2);
		}else {
			newhead = l2;
			newhead.next = mergeTwoLists(l1, l2.next);
			
			
		}
		return newhead;								
	}
	
	
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(-9);
		ListNode l3 = new ListNode(3);
		
		l1.next = l3;
		l3.next = null;
		ListNode l2 = new ListNode(5);
		ListNode l4 = new ListNode(7);
		l2.next = l4;
		l4.next = null;
		mergeTwoLists(l1, l2);
	}
}
