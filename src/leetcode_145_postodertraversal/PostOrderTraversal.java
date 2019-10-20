package leetcode_145_postodertraversal;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;




public class PostOrderTraversal {
		public static void postOrderTraversal(TreeNode root) {
			if(root != null) {
				Stack<TreeNode> st = new Stack<>();
				Stack<Integer> help = new Stack<>();
				st.push(root);
				while(!st.isEmpty()) {
					root = st.pop();
					help.push(root.val);
					if(root.left!=null) {
						st.push(root.left);
						
					}
					if(root.right!=null) {
						st.push(root.right);
					}
					
				}
			}
			
		}
		public List<Integer> postorderTraversal1(TreeNode root){
			LinkedList<Integer> res = new LinkedList<>();
			Stack<TreeNode> st = new Stack<>();
			
			while(root!=null || !st.isEmpty()) {
				if(root!=null) {
					st.push(root);
					res.addFirst(root.val);
					root = root.right;
				}else {
					root = st.pop();
					root = root.left;
				}
			}
			return res;
			
		}
		public List<Integer> postorderTraversal(TreeNode root){//覺得這種方式比左的更好理解
			LinkedList<Integer> res = new LinkedList<>();
			Stack<TreeNode> st = new Stack<>();
			TreeNode last = null;
			TreeNode top = null;
			
			while(root!= null || !st.isEmpty()) {
				if(root!= null) {
					st.push(root);
					root = root.left;
				}else {
					top = st.peek();
					if(top.right!=null && top.right != last) {
						root = top.right;
					}else {
						res.add(top.val);
						last = st.pop();
					}
				}
			}
			return res;
		}
		public List<Integer> postorderTraversal2(TreeNode root) {
			LinkedList<Integer> res = new LinkedList<>();
	        if(root != null) {
	        	Stack<TreeNode> st = new Stack<>();
	        	st.push(root);
	        	while(!st.isEmpty()) {
	        		root = st.pop();
	        		res.addFirst(root.val);
	        		
	        		if(root.left!=null) {
	        			st.push(root.left);
	        		
	        		}
	        		if(root.right!=null) {
	        			st.push(root.right);
	        		}
	
	        	}
	      
	        }
	        return res;
	    }
		 public ArrayList<Integer> postorderTraversal3(TreeNode root) {//也是比较麻烦的写法，但也是按照先走完走边来写的
			          // write your code here
			          ArrayList<Integer> result = new ArrayList<Integer>();
			          Stack<TreeNode> stack = new Stack<TreeNode>();
			          TreeNode cur = root;
			          TreeNode prev = null;
			          if (root == null) {
			              return result;
			          }
			         stack.push(root);
			         while (!stack.isEmpty()) {
			             cur = stack.peek();
			             if (prev == null || prev.left == cur || prev.right == cur) { //traverse down the tree
			                 if (cur.left != null) {
			                     stack.push(cur.left);
			                 }
			                 else if (cur.right != null) {
			                     stack.push(cur.right);
			                }
			             }
			             else if (cur.left == prev) {//traverse up the tree from the left
			                 if (cur.right != null) {
			                     stack.push(cur.right);
			                 }
			             }
			             else {
			                 result.add(cur.val);
			                 stack.pop();
			             }
			             prev = cur;
			         }
			         return result;
			     }
		 public List<Integer> postorderTraversal4(TreeNode root)    //非递归后序遍历
		 {	 //类似于左的前序遍历的出入栈顺序，自己画一下，根据左前序遍历改的
			 LinkedList<Integer> res = new LinkedList<>();
			 if(root != null) {
				 Stack<TreeNode> s = new Stack<>();
				 TreeNode cur = null;                      //当前结点 
				 TreeNode pre= null;                 //前一次访问的结点 
				 s.push(root);
				 while(!s.empty())
				 {
					 cur=s.peek();
					 if((cur.left==null&&cur.right==null)||
							 (pre!=null&&(pre==cur.left||pre==cur.right)))
					 {
						 System.out.println();  //如果当前结点没有孩子结点或者孩子节点都已被访问过 
						 res.add(s.pop().val);
						 
						 pre=cur; 
					 }
					 else
					 {
						 if(cur.right!=null)
							 s.push(cur.right);
						 if(cur.left!=null)    
		                 s.push(cur.left);
					 }
				 }   
			 }
		     return res;
		 }
}
