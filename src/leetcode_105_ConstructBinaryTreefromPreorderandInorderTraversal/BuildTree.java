package leetcode_105_ConstructBinaryTreefromPreorderandInorderTraversal;



public class BuildTree {
	public class TreeNode {
		
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int data) {
			this.val = data;
		}
	
	}
	public class Solution{
		 public TreeNode buildTree(int[] preorder, int[] inorder) {
			 return helper(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
			 
		 }
		 public TreeNode helper(int[] preorder,int[] inorder,int pre_start,
				 int pre_end,int in_start,int in_end) {
			 
			if(pre_start <= pre_end && in_start <= in_end 
					&& pre_end<preorder.length && in_end <inorder.length) {
				
				TreeNode root = new TreeNode(preorder[pre_start]);
				int index = 0;
				for(index = in_start;index < in_end; index++) {
					if(preorder[pre_start] == inorder[index]) {
						break;
					}
				}
				root.left = helper(preorder,inorder,pre_start + 1,pre_start+index-in_start,in_start,index - 1);
				root.right = helper(preorder,inorder,pre_start+index-in_start + 1,pre_end,index+1,in_end);
					 
				//helper(preorder,inorder,pre_start + 1,index,in_start,index - 1);
				//helper(preorder,inorder,index + 1,pre_end,index+1,in_end);
				return root;
			}
			return null;
		 }
	}
}
