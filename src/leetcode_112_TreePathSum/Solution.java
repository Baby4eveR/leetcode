package leetcode_112_TreePathSum;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	public boolean hasPathSum1(TreeNode root, int sum) {
		        if(root == null) return false;
		    
		        if(root.left == null && root.right == null && sum - root.val == 0) return true;
		    
		        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
		    }
	
	 public boolean hasPathSum(TreeNode root, int sum) {//自己写的通过的代码，留着自己看看多丑陋
		 	if(root == null ) {							//但是自己写的代码很不简洁
		 											//其实就是看节点是不是空，节点是不是叶子节点两个递归基
	        	return false;
		 	}
     
	        if(root.val == sum && root.left == null && root.right == null) {
	        	return true;
	        }else if(root.val != sum&& root.left == null && root.right == null ){
	        	return false;
	        }
	        boolean result1 = false;
	        if(root.left!= null) {
	        	 result1 = hasPathSum(root.left, sum-root.val);
	        	
	        	} 
	        boolean result2 = false;
	        if(root.right!=null) {	
	        	 result2 = hasPathSum(root.right, sum-root.val);
	        }
	        
			return result1 || result2 ;
	    }
	 public boolean hasPathSumUnrecur(TreeNode root, int sum) {
		 if(root == null ) {//根据后续遍历改写的
			 return false;
		 }
		Stack<TreeNode> st = new Stack<>();
		TreeNode top = null;
		TreeNode last = null;
		int count = 0;
		while(root!= null || !st.isEmpty()) {
			if(root != null) {
				st.push(root);
				count = count + root.val;
				root = root.left;
			}else {
				top = st.peek();
				if( top.right!=null && top.right!= last) {
					root = top.right;
					//count = count + top.right.val;不应该有这句，加的值应该都在if（root！=null）中
					
				}else {
					last = st.pop();
					if( count == sum && last.left == null && last.right == null) {
						return true;
					}else {
						count =count - last.val;
					}
				}
				
			}
		}
		return false;
	 }
	 
}
