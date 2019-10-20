package leetcode_102_leveltravsal;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LevelTraversal {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) {
        	return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode last = root;
        TreeNode next_last = null;
        while(!queue.isEmpty()) {
        	LinkedList<Integer> level_res = new LinkedList<>(); 
        	
        	
        		//TreeNode temp =queue.poll();
        		root = queue.poll();
        		level_res.add(root.val);
        		if(root.left!=null) {
        			queue.add(root.left);
        			next_last = root.left;
        		}
        		if(root.right!=null) {
        			queue.add(root.right);
        			next_last = root.right;
        		}
        		if(root == last) {
        			res.add(level_res);
        			last = next_last;
        		}
        	
        	
        		
        }
        return res;
    }
	  public List<List<Integer>> levelOrder1(TreeNode root) {
	        List<List<Integer>> res = new LinkedList<>();
	        if(root == null) {
	        	return res;
	        }
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.add(root);
	        while(!queue.isEmpty()) {
	        	LinkedList<Integer> level_res = new LinkedList<>(); 
	        	int size = queue.size();
	        	//root = queue.peek();
	        	
	        	for(int i = 0;i<size;i++) {
	        		//TreeNode temp =queue.poll();
	        		root = queue.poll();
	        		level_res.add(root.val);
	        		if(root.left!=null) {
	        			queue.add(root.left);
	        		}
	        		if(root.right!=null) {
	        			queue.add(root.right);
	        		}
	        	}
	        	res.add(level_res);
	        }
	        return res;
	    }
	public List<List<Integer>> levelOrderRecur(TreeNode root){
		  List<List<Integer>> res = new LinkedList<List<Integer>>();
		  if(root == null ) {
			  return res;
		  }
		  levelprocess(res,root,0);
		  return res;
	  }
	private void levelprocess(List<List<Integer>> res, TreeNode root, int level) {
		if(root == null) {
			return;
		}
		if(res.size()<=level) {
			res.add(new LinkedList<Integer>());
		}
		levelprocess(res, root.left, level+1);
		levelprocess(res, root.right, level+1);
		res.get(level).add(root.val);
	}
	
}
