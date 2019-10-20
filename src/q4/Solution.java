package q4;

public class Solution {
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

	    TreeNode root = reConstruct( pre, in, 0,pre.length-1, 0,in.length-1);
	    return root;
	    }
	        
	public static TreeNode reConstruct(int[] pre,int[] in,
			   								int prestart,int preend,int instart,int inend){
	       
	       
	       if(prestart>preend ||instart>inend){
	           return null;
	       }
	       TreeNode root = new TreeNode(pre[prestart]);
	        
	       for (int i = instart;i<=inend;i++){
	            
            if(in[i] ==pre[prestart]){
	              
	                root.left = reConstruct(pre,in,prestart+1,prestart+i-instart,instart,i-1);
	                root.right = reConstruct(pre,in,prestart+i-instart+1,preend,i+1,inend);
	              
	            }
	 
	        }
	       return root;
	   }
}
