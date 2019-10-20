package leetcode_572_SubtreeofAnotherTree;

//判断是不是二叉树的子树
public class Solution {
	public boolean isSubtree(TreeNode s, TreeNode t) {
	        if(s == null) {
	        	return false;
	        			
	        }
	        if(t == null) {
	        	return false;
	        			
	        }/*优化一下以下代码
	        *
	        *
	        *if(hasSameElment(s,t)){
	        * result =true; }
	        *
	        *return isSubtree(s.left, t)||
	        			isSubtree(s.right, t);
	        *
	        *isSubTree来判断哪个节点和子树根节点相同；
	        *hasSameElment判断子树的所有节点是否相同；
	        *
	        *
	        */
	        if(s.val == t.val) {
	        	 hasSameElment(s, t);
	        	
	        }
           if(hasSameElment(s,t	)==false){
	        return isSubtree(s.left, t)||
	        			isSubtree(s.right, t);}
           else{return true;}
	        /*这么写会有错误，相当于判断完第一个和子树根节点相同的位置后就返回接过来，不会走else，也就不会去找其他和子树根节点相同的位置；
	         * if(s.val == t.val) {
	        	return hasSameElment( s, t);
	        	
	        }else {
	        	return isSubtree(s.left, t)||
	        			isSubtree(s.right, t);
	        }*/
	  }
	public static boolean hasSameElment(TreeNode s,TreeNode t) {
		if(s == null && t == null) {
			return true;
			
		}
		if(s != null && t == null ) {
			return false;
		}
		if( s == null && t != null) {
			return false;
		}
		if(s.val != t.val) {
			return false;
		}
		return hasSameElment(s.left, t.left)&&hasSameElment(s.right, t.right);
		
	}
}
