package leetcode_111_MinimumDepthofBinaryTree;

import java.util.LinkedList;
import java.util.Queue;


public class Solution {
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	public int minDepth(TreeNode root) {
       /* if(root ==null) {
        	return 0;
        }这种写法少考虑了条件；如1-null-2  左子树为空，深度就是右侧的，因为左子树没有叶子节点
        return 1+Math.min( minDepth(root.left),minDepth(root.right) );*/
		int result = 0;
		if(root ==null) {
        	return  0;
        }
		if(root.left == null && root.right == null) {
			result = 1;
		}
		if(root.left != null&&root.right!=null){
			result = 1 + Math.min( minDepth(root.left),minDepth(root.right) );
		}else if(root.left!=null){
			result = 1 + minDepth(root.left);
		}else {
			result = 1 + minDepth(root.right);
		}
		/*if(root.left != null) {
			result = 1 + minDepth(root.left);
		}
		if(root.right !=  null) {
			result = 1 + minDepth(root.right);
		}*/
		return  result;
    }
	public int minDepthRecur(TreeNode root) {//更精炼的递归写法
		if(root == null) {
			return 0;
		}
		
		int left =minDepth(root.left);
		int right = minDepth(root.right);
		
		return (left == 0 || right == 0) ? left + right +1 : Math.min(left, right)+1;
		
		
	}
	public int minDepthUnrecur(TreeNode root) {//深度遍历改的
		
		return 0;
	}
	public int minDepthUnrecur1(TreeNode root) {//层次遍历改的
		if(root == null) {
			return 0;
		}
        Queue<TreeNode> queue = new LinkedList<>();
        int min = 0;
        int depth =1;
        
        
        queue.add(root);
        
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	depth++;
        	
        	for(int i =0;i<size;i++) {
        		root = queue.poll();
        		if(root.left == null && root.right == null) {//只要这一层有一个节点是叶子节点，那么最小深度就是到此叶子的深度
        			min = depth-1;	// 不要再写成depth--了，返回值是depth，不是depth-1
        			return min; 	//这时已经找到了最小深度，直接返回，不要在遍历了
        		}
        		if(root.left != null) {
        			queue.add(root.left);
        		}
        		if(root.right != null) {
        			queue.add(root.right);        			
        		}
        	}

        }
        return min;
        
    }
}
