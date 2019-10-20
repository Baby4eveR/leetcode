package jianzhi_24_VerifySquenceOfBST;
//牛客上剑指offer，验证二叉树的后序遍历序列
public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
    	
        if(sequence == null || sequence.length == 0) {
        	return false;
        }
        int len = sequence.length;
       
		return helper( sequence,0 ,len-1) ;
       
        
    }

	private boolean helper(int[] sequence, int start, int end) {
			if(start > end) {
				return false;
			}
			int pivort = 0;
			for(pivort =start;pivort<=end;pivort++) {//直接写for(int i =0;i<=end;i++){
													//	if(sequence[pivort] > sequence[end]) {
													//		pivort = i;
													//		break;
													//		}
													//	} 错误，因为pivort
				if(sequence[pivort] > sequence[end]) {//可能没有找到，那样就会没有赋值，还用的是0		
					
					break;
				}
			}
			for(int j = pivort;j<=end;j++) {
				if(sequence[j] < sequence[pivort]) {
					return false;
				}
			}
		
		return helper(sequence,0,pivort -1) && helper(sequence,pivort,end);
	}
}
