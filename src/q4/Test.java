package q4;

public class Test {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(3);
		TreeNode t3 = new TreeNode(4);
		TreeNode t4 = new TreeNode(5);
		TreeNode t5 = new TreeNode(6);
		TreeNode t6 = new TreeNode(7);
		TreeNode t7 = new TreeNode(8);
		
		root.left = t1;
		root.right = t2;
		t1.left = t3;
		t2.left = t4;
		t2.right = t5;
		t3.right = t6;
		t5.left = t7;
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		
		Solution sl = new Solution();
		TreeNode res = sl.reConstructBinaryTree(pre, in);
		System.out.println(res.val);
		System.out.println(res.left.val);
		System.out.println(res.right.val);
		
		
	}
}
