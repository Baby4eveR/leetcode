package leetcode_104_MaximumDepthofBinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class leetcode_104_MaximumDepthofBinaryTree {
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	public static int height = 0;
	public int maxDepth(TreeNode root) {//递归要从总体去把握
		if(root == null) {
			return 0;
			
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        
        
    }
	
	
	
	public int maxDepthUnrecur(TreeNode root) {//使用stack
		if(root == null) {
			return 0;
			
		}
		Stack<TreeNode> st = new Stack<>();
		Stack<Integer> val_st = new Stack<>();
		int max = 0;
		int cur = 0;
		
		
		st.push(root);
		val_st.push(1);
		while(!st.isEmpty()) {
			root = st.pop();
			cur = val_st.pop();
			max = Math.max(max, cur);
			
			if(root.left!=null) {
				st.push(root.left);
				val_st.push(cur+1);//不能用++，会产生副作用
			}
			if(root.right!= null) {
				st.push(root.right);
				val_st.push(cur+1);
			}
		}
		return max;	
	}
	public int maxDepthUnrecur3(TreeNode root) {//使用queue
		if(root == null) {
			return 0;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int depth =1;
		
		
		while(!queue.isEmpty()) {
			//root = queue.poll();
			int size = queue.size();
			depth++;
			
			for(int i = 0;i < size; i ++) {
				root = queue.poll();
				if(root.left!=null) {
					queue.add(root.left);
					
				}
				if(root.right!=null) {
					queue.add(root.right);
				}
			}

		}
		return depth;
		
	}
	
	public int maxDepthUnrecur2(TreeNode root) {
		if(root == null ) {
			return 0;
			
		}
		int max = 0;
		int temp = 1;
		Stack<TreeNode> st = new Stack<>();
		Stack<Integer> depth = new Stack<>();
		
		while(root!=null || !st.isEmpty()) {
			if(root!= null) {
				st.push(root);
				depth.push(temp);
				
				temp = depth.peek();
				max = Math.max(temp, max);
				
				root = root.left;
				temp++;

			}else {
				root = st.pop();
				
				root= root.right;
				if(root == null) {
					temp = depth.pop();
				}else {
					temp = depth.pop() + 1;
				}
			}
		}
		return max;
        
        
    }
	public int maxDepth1(TreeNode root) {//自己写的
		
        
        int depth =0;
        depth = maxDepthHelper(root,depth);//depth = maxDepthHelper(root,depth+1)不对
        
        return depth;
    }
	private int maxDepthHelper(TreeNode root, int level) {
		if(root == null ) {
			return level;
		}
		int left =  maxDepthHelper(root.left, level);
		int right = maxDepthHelper(root.right, level);//这里level不要+1
		return left>right ? left+1 : right+1;//这里加1
		//发现传递的level参数并没有什么用，root ==null时返回0，没必要按照层次遍历的想法，递归函数参数中带层数
		//层次遍历的层数是上一层给下一层的，不给的话没地方拿到，需要这个值，所以作为递归函数的新增参数传递，
		//而且层次遍历那个递归的函数没有返回值，只能从参数往下传，要改成带返回值的，只能返回左右子树较大的，这不就是这题的写法吗
		//这道题深度是由下向上返回的，以返回值返回，
	}
	
}
