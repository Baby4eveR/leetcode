package jianzhi_27_BstToDouList;

import java.util.Stack;

public class Solution {
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	public void test() {//非静态方法可以访问非静态，实例化时会一起被加载
		inner();
		
	}
	public static void inner() {//静态访问非静态不行，因为内存中还没有，需要实例化
		//test();
	}
	public TreeNode ConvertUnreur(TreeNode root) {//ac代码，非递归版本
		Stack<TreeNode> st = new Stack<>();
		TreeNode pre = null;
		
		while(root!=null|| !st.isEmpty()) {
			if(root!=null) {
			st.push(root);
			root = root.left;
			//pre = root;  pre只在pop时候改，初始设置成null
		}else{
			root= st.pop();
			root.left =pre;
			if(pre!=null) {
				pre.right = root;
			}
			pre = root;
			root = root.right;
			}
		
		}
		return pre;
		
	}
	
	 public TreeNode Convert(TreeNode root){  

	        //helper(root);  
	        TreeNode pre = null;//pre是每个子树处理完后的链表的尾部
	        pre = convertToDoublyLinkedList(root,pre);
	        while(pre != null && pre.left!= null){  
	            pre = pre.left;  
	        }  
	        return pre;  
	    }  
	 
	 
	 public TreeNode convertToDoublyLinkedList(TreeNode root,TreeNode pre) {
			if (root == null)
				return pre;
			pre = convertToDoublyLinkedList(root.left, pre);
			root.left = pre;
			if (pre != null)
				pre.right = root;
			pre = root;
			return convertToDoublyLinkedList(root.right, pre);
		}
	 
	
}
