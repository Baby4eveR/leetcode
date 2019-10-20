package leetcode_206_ReverseLinkedList;
//反转链表

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public ListNode reverseList(ListNode head) {
		
        /*迭代版本
         * if(head == null || head.next == null)
            return head;
        
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        
        while(cur!=null){
            next = cur.next;
            cur.next = pre;
            pre  = cur;
            cur = next;
            
            
        }
        return pre;
    }*/
        if(head == null || head.next == null)
            return head;        // head.next==null时递归基的处理，也就是只有一个节点，直接返回当前节点为新的头节点；
        
        ListNode newhead = reverseList(head.next);
        head.next.next = head;  //这两行时非基准情况时的处理   递归的两种模型
        head.next = null;
        
        return newhead;
    }    
}
