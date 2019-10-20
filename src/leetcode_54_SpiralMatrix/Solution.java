package leetcode_54_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		List< Integer> l = new ArrayList<>();
		System.out.println(l.size());
	}


	 public List<Integer> spiralOrder(int[][] matrix) {


		 	if(matrix == null) {
		 		return null;
		 	}
		 	List<Integer> res = new ArrayList<>();
		 	if(matrix.length == 0) {  //数组长度可能为零，这是要返回空的链表；
		 		return res;
		 	}
		 	int row_start = 0;
		 	int col_start = 0;
		 	
	        int row_end = matrix.length-1;
	        
	        int col_end = matrix[0].length-1;
	        
	        
	        while(row_start<=row_end&&col_start<=col_end) {
	        	printarray(matrix,row_start,row_end,col_start,col_end,res);
	        	row_start++;
	        	row_end--;
	        	col_start++;
	        	col_end--;
	        }
	        return res;
	    }

	private List<Integer> printarray(int[][] matrix, int row_start, int row_end, int col_start, int col_end,
			List<Integer> res) {
		
			if(row_start == row_end) {
				while(col_start<=col_end) {
					res.add(matrix[row_start][col_start]);
					col_start++;
					}
			}else if(col_start == col_end) {
					while(row_start<=row_end) {
						res.add(matrix[row_start][col_start]);
						row_start++;
						}
			}else {
					for(int i=col_start;i<col_end;i++) {
						res.add(matrix[row_start][i]);
					}
					
					for(int i = row_start;i<row_end;i++) {
						res.add(matrix[i][col_end]);
						
					}
					for(int i = col_end;i>col_start;i--) {
						res.add(matrix[row_end][i]);
					}
					for(int i = row_end;i>row_start;i--) {
						res.add(matrix[i][col_start]);
					}
					
				}

			return res;
	}
}
