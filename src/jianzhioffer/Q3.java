package jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;

public class Q3 {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        
        if (listNode == null ) return al;
        while(listNode!=null) {
        	result.add(listNode.val);
        	listNode= listNode.next;
        }
        for(int x=result.size()-1;x>=0;x--) {//用list模拟stack
        	al.add(result.get(x));
        	
        }
        
        return al;
    }
	public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		Stack<Integer> st = new Stack<>();  //使用stack，先进后出保证倒叙遍历
		ArrayList<Integer> al = new ArrayList<>();
		if(listNode == null ) return al;
		
		while(listNode != null) {
			st.push(listNode.val);
			listNode = listNode.next;
			
		}
		
		while(!st.isEmpty()) {
			al.add(st.pop());
			
		}
		return al;
		
	}
	
}
