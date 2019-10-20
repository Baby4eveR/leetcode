package leetcode_144_preoderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreTraversal {
	public static List<Integer> preTravrsalRecur1(TreeNode root) {
		//需要返回一个list的版本,leetcode
		List<Integer> res = new ArrayList<>();
		if(root == null) {
			return res;       //返回的是一个空的链表，没有元素
		}
		res.add(root.value);
		res.addAll(preTravrsalRecur1(root.left));//每一个节点返回的都是一个list，用addAll将返回的
												//list中的元素加入上一级节点的list中
		
		res.addAll(preTravrsalRecur1(root.right));
		return res;
	}
	
	
	
	public static void preTravrsalRecur(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.println(root.value);
		preTravrsalRecur(root.left);
		preTravrsalRecur(root.right);
	}
	
	public static void preTravrsal(TreeNode root) {
		//需要返回一个list的版本,leetcode,迭代
		if(root != null ) {
			Stack<TreeNode> st = new Stack<>();
			st.push(root);
			while(!st.isEmpty()) {
				root = st.pop();
				System.out.println(root.value);
				if(root.right!=null) {
					st.push(root.right);
				}
				if(root.left!=null) {
					st.push(root.left);
				}
			 }
	    }
	}
	
	public static List<Integer> preTravrsal1(TreeNode root){
		List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        while(root!=null || !st.isEmpty()) {  

        	if(root!=null) {
        		st.push(root);
        		res.add(root.value);
        		root = root.left;
        	}else {
        		root = st.pop();
        		root = root.right;
        	}
        	
        	
        }
        
        return res;
	} 
	
	public static List<Integer> preTravrsal2(TreeNode root) {
		
		List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root!=null){
            st.push(root);
            while(!st.isEmpty()){
                root = st.pop();
                res.add(root.value);
                if(root.right!=null){
                    st.push(root.right);
                    
                }
                if(root.left!=null){
                    st.push(root.left);
                }
            }
        }
        return res;
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		preTravrsalRecur(root);
		List<Integer> res = preTravrsalRecur1(root);
		for(Integer i : res) {
			System.out.println(i);
		}
	}
}
