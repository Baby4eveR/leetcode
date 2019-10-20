package leetcode_98_ValidateBinarySearchTree;
//根据中序遍历序列改写，中序遍历正好是递增的序列
//需要保存中序遍历的前一个节点值，正好右节点的值是当前子树的最大值，上一层节点需要比这个节点的值更大
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	public boolean isValidBSTRecur(TreeNode root) {
		if(root == null ) {
			return true;
			
		}
		
		long max = Long.MAX_VALUE;
		long min = Long.MIN_VALUE;
		
		return  helper(root,max,min);
		
	}
	private boolean helper(TreeNode root, long max, long min) {
		if(root == null) {
			return true;
		}
		if(root.val >max || root.val < min) {
			return false;
		}
		return helper(root.left,root.val,min) && helper(root.right,max,root.val);
	}
	public boolean isValidBST(TreeNode root) {
//        	Queue<Integer> queue = new LinkedList<>();
//        	queue.add(root);
//        	
//        	while(!queue.isEmpty()) {
//        		
//        		
//        		
//        	}
			if(root == null) {
				return true;
			}
        	
        	Stack<TreeNode> st = new Stack<>();
        	TreeNode pre = null;
        	
        	while(root!=null || st.isEmpty()) {
        		if(root!=null) {
        			st.push(root);//将root入栈，不要总写成将root.left入栈
        			root = root.left;
        			
        		}
        		else{
        			root = st.pop();
        			if(pre!=null && root.val <= pre.val) {//只要有一个节点不满足当前节点比前一节点的值大，就直接返回
        				return false;
        			}
        			root = root.right;
        		}
        	}
        	return true;
    }
}
