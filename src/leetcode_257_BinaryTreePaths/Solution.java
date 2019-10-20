package leetcode_257_BinaryTreePaths;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;



public class Solution {
	public static void main(String[] args) {
		Integer left =0;
		int right = 0 ;
		int[] p = new int[1];
		String str = "111";
		change(p,str);
		System.out.println(p[0]);
		System.out.println(str);
	}
	private static void change(int[] left,String str) {
		left[0]=left[0]+1;
		str= str+"gaibian";
	}
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	 public List<String> binaryTreePaths(TreeNode root) {
		 List<String> res = new LinkedList<>();
	     if(root == null ) {
	        	 return res;
	        }
	     process(root,"",res);
	     return res;
	        
	        
	    }
	 public void process(TreeNode root,String path,List<String> res) {
		//这种下一次递归需要上一次结果的情况，都需要把上一次的结果传到下一层
		 //这是在整体上的理解，其实代码跑的过程中还是从底层返回上来的；
		 if(root.left == null && root.right == null) {
			 res.add(path+root.val);//叶子节点时直接在路径上添加当前节点值
		 }
		 if(root.left!=null) {//每次传给下一层的path都是上一层的path+本节点值+"->",根节点的上一层path是空字符串
			 process(root.left,path+root.val+"->",res);
		 }
		 if(root.right!=null) {
			 process(root.right,path+root.val+"->",res);
		 }
		 
	 }
	 public List<String> binaryTreePaths1(TreeNode root) {
		 List<String> res = new LinkedList<>();
		 Stack<TreeNode> node_stack = new Stack<>();
		 Stack<String> path_stack = new Stack<>();
		 String cur_path = "";
	     if(root == null ) {
	        	 return res;
	        }
	     while(root!=null || !node_stack.isEmpty()) {
	    	 if(root!=null) {
	    		 node_stack.push(root);
	    		 if(root.left == null && root.right == null) {
	    			 cur_path = cur_path+root.val;
	    			 path_stack.push(cur_path);
	    			 res.add(cur_path);//到达叶子节点，路径添加到结果集合中
	    			 
	    		 }else {
	    			 cur_path = cur_path+root.val+"->";
	    			 path_stack.push(cur_path);
	    		 }
	    		 root = root.left;
	    	 }else {
	    		 root = node_stack.pop();
	    		 root = root.right;
	    		 cur_path = path_stack.pop();
	    		 //cur_path = path_stack.peek(); 错误的方式，应该弹出，路径栈中存贮的是达到当前节点的路径
	    		 //当前节点为新pop出来的节点，也就是栈顶元素
	    	 }
	     }
	     return res;
	    }
	 
}
