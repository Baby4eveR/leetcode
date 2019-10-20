package leetcode_101_SymmetricTree;


public class Solution {
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	public boolean isSymmetric(TreeNode root) {
	        if(root == null){
	            return true;
	        }
	        return isSame(root,root);
	    }
	public boolean isSame(TreeNode left,TreeNode right){
		    if(left == null && right == null){
	            return true;
	        }
	        if(left ==  null || right == null){
	            return false;
	        }
	        if(left.val != right.val){
	            return false;
	        }
	        return (left.val==right.val) && isSame(left.left,right.right)&&isSame(left.right,right.left);

	    }
	
	
	public boolean isSymmetric1(TreeNode root) {
	    return isMirror(root, root);
	}

	public boolean isMirror(TreeNode t1, TreeNode t2) {
	    if (t1 == null && t2 == null) return true;
	    if (t1 == null || t2 == null) return false;
	    return (t1.val == t2.val)
	        && isMirror(t1.right, t2.left)
	        && isMirror(t1.left, t2.right);
	
	}
}
