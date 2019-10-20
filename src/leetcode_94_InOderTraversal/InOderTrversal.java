package leetcode_94_InOderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;



public class InOderTrversal {
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<>();
    	Stack<TreeNode> st = new Stack<>();
    	
    	while(root!=null || !st.isEmpty()) {
    		if(root!=null) {
    			st.push(root);
    			root = root.left;
    			
    		}else{
    			root = st.pop();
    			res.add(root.val);
    			root = root.right;
    		}
    		
    	}
    	return res;

	}
	
	
	public List<Integer> inorderTraversal1(TreeNode root) {
        	List<Integer> res = new ArrayList<>();
        	Stack<TreeNode> st = new Stack<>();
        	
        	while(true) {
	        	if(root!=null) {
	        		while(root!=null) {
	        			st.push(root);
	        			root = root.left;
	        		}
	        		
	        		
	        	}else if(!st.isEmpty()) {
	        		root = st.pop();
	        		res.add(root.val);
	        		root = root.right;
	        	}else {
	        		break;
	        	}
        	}
        	return res;
    }
	public static void inOderTraversal(TreeNode root) {
		if(root!= null) {
			Stack<TreeNode> st = new Stack<>();
			while(!st.isEmpty() || root!=null) {
				if(root!=null) {
					st.push(root);
					root =root.left;
				}else {
					root =st.pop();
					System.out.println(root.val);
					root = root.right;
				}
			}

		}
	}
}
