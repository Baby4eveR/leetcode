package leetcode_110_BalancedBinaryTree;



public class Solution {
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	
	
	public boolean isBalanced(TreeNode root) {
		if(root == null ) {
			return true;
		}
		int[] depth = {0};
		return helper(root,depth);
	}
	public boolean isBalanced2(TreeNode root) {
		if(root == null ) {
			return true;
		}
		
		return isBst(root) != -1;
	}
	public int isBst(TreeNode root) {//这其实相当于在求树的高度的过程中直接进行判断，不是就返回-1
									//剑指offer上的辅助方法由于要返回boolean，所以需要搞一个引用类型来存储高度
									//因为基本类型是传值，没有c的指针
									//其实完全这两种是一样的，只不过这种省去了传递一个高度的参数
		if(root == null) {			//java里没指针，一种是用int[]数组这种引用对象代替实现，一种是将需要的值作为返回值返回
									//但需要用int[]数组对象去存储，要不然改变不了值  可以用一个int返回值代替，数组也只是用了第一个元素
			return 0;				//这个递归就是将Math.abs(ldepth-rdepth)作为返回值返回了
		}							//
		int ldepth = isBst(root.left);
		if(ldepth == -1) {
			return -1;
		}
		int rdepth = isBst(root.right);
		if(rdepth == -1) {
			return -1;
		}
		if(Math.abs(ldepth-rdepth) > 1 ) {
			return -1;
		}
		return Math.max(ldepth, rdepth) + 1;		
	}
	
	
	private boolean helper(TreeNode root, int[] depth) {//int[] depth相当于二级指针
		if(root == null) {//剑指offer说的后序遍历，先走到最底部的左右子树，判断是不是平衡树，再判断他俩的父节点出是不是平衡树
			depth[0] = 0;
			return true;
		}
		int[] ldepth = new int[1];
		int[] rdepth = new int[1];
		if( helper(root.left,ldepth) && helper(root.right,rdepth) ){//这个和下面的解法是反过来的，先判断左右子树是不是bst
			if( Math.abs(ldepth[0]-rdepth[0]) <= 1 ) {    //下面的方法求高度，先判断root是不是，再判断左右子树是不是
				depth[0] = Math.max(ldepth[0], rdepth[0]);
				return true;
			}

		}
		return false;
	}


	public boolean isBalanced1(TreeNode root) {//这是一个不好的解答，相当于从上到下的判断每个节点的左子树和右子树
												//存在同一个节点遍历多次的情况
		if(root == null) {  
			return true;					//这个相当于前序遍历
		}						
		int left = maxDepth(root.left);//这两行一起是root的操作
		int right = maxDepth(root.right);//
		if(Math.abs(left-right)<=1) {
			return isBalanced(root.left) && isBalanced(root.right);//这是左右子树的操作
		}
		return  false;
		
		
	}
	public int maxDepth(TreeNode root) {//递归要从总体去把握
		if(root == null) {
			return 0;
			
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        
        
    }
	
}
