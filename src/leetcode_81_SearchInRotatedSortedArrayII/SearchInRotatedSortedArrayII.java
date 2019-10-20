package leetcode_81_SearchInRotatedSortedArrayII;

public class SearchInRotatedSortedArrayII {//效率上和leetcode的答案差别不大，但是思想更统一
	 public boolean search(int[] nums, int target) {
		 if(null == nums) {
				return false;
			}
			int start = 0;
	        int end = nums.length-1;
	        int mid = 0 ;
			while(start <= end) {
				mid = start + (end - start)/2;
				if(nums[mid] == target) {
					return true;
				}
				if(nums[start] < nums[end]) {//说明此时数组完全没有旋转,直接按照有序数组的二分搜索来
								//if(nums[0] < nums[end]) { 刚开始写错了，不应该是nums[0],应该是nums[start]
					if(nums[mid] > target) {
						end = mid -1;
					}else {
						start = mid + 1;//什么时候+1，什么-1，也就是包含不包含
					}
					continue;
				}
				if(nums[start] > nums[mid]) {
					if(nums[mid] <= target && target <= nums[end]) {
						start = mid;
					}else {
						end = mid - 1;
					}
					continue;
				}
				if(nums[mid] > nums[end]) {
					if(nums[mid] >= target && target >= nums[start]) {
						end = mid;
					}else {
						start = mid + 1;
					}
					continue;
				}else {
					start++;
				}//这段for也可以用start++代替
				/*for(int i = start;i <= end;i++) {
					if(nums[i]!=nums[mid]) {
						if(i<mid) {
							end = mid - 1;
						}else {
							start = mid + 1;
						}
						break;
					}
					if(i == end && nums[i] == nums[mid]) {
						return false;
					}
				}*/
			}
			return false;
	    }
}
