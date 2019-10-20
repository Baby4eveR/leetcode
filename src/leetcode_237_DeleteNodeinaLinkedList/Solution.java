package leetcode_237_DeleteNodeinaLinkedList;
//这题很简单，边界条件都不用考虑，删除单个节点，给定了不是尾节点，没有重复值
public class Solution {
	public static void deleteNode(ListNode node) {
       node.val = node.next.val;
       node.next = node.next.next;
    }
}
