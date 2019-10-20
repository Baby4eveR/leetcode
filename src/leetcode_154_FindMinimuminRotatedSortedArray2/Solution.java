package leetcode_154_FindMinimuminRotatedSortedArray2;
//旋转数组中的最小值，此题有重复数字，注意看注释
public class Solution {
	 public static int findMin(int[] nums) {
		 	if(null == nums){
		 		return 0;
		 		}
		 	
		 	
	        int start = 0;
	        int end = nums.length-1;
	        
	        while(start < end ) {
	        	if(nums[start] < nums[end]) {
	        		break;
	        		//return nums[start];
	        	}
	        	if(start == end -1 ) {
	        		break;
	        		//return Math.min(nums[start], nums[end]);
	        	}
	        	
	        	
	        	int mid = (start + end )>>1;
	        
	        	//这样的分类方式并不好，没有做到完备的分类。case：2，2，2，0，1
	        	//没有考虑右侧，直接就遍历数组了
	        	//应按照左的书，分为start>mid，mid>end，因为start>=end，所以以上
	        	//两类不满足时，只剩下start《=mid,mid<=end，也就是start== mid ==end
	        	//要先考虑一次未旋转的情况，还要考虑只剩两个元素的情况
	        	//与二分查找不同的是，不用取等号来达到只有一个元素的情况
	        	if(nums[start] < nums[mid]) {
	        		start = mid;
	        		continue;
	        		
	        		
	        	}
	        	if(nums[mid]< nums[end]) {
	        		end = mid;
	        		continue;//注意continue
	        	}
	        	if(nums[start] == nums[mid] && nums[mid] == nums[end]) {
	        		int min = nums[start];
		        	for(int i = start;i<=end;i++) {
		        		
		        		if(min>nums[i]) {
		        			min = nums[i];
		        		}
		        	}
			        return min;
	        	}
	        	
	        }
	        return Math.min(nums[start], nums[end]);
	    }
	 
	
}
