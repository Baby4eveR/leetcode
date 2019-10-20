package leetcode_153_FindMinimuminRotatedSortedArray;
//旋转数组最小值，此题无重复数字
public class Solution {
		public static int findMin(int[] nums) {
				if(null == nums || 1 == nums.length  ) {
					return 0;
				}
				int p1 = 0;
				int p2 = nums.length - 1;
				
				int mid = 0;
				while (p1 < p2) {
					mid = p1 + ( p2 - p1 ) /2;
					if(nums[p2] < nums[mid]) {
						p1 = mid+1;
						
					}else {
						p2 = mid;
					}
				}
				/*
				 * while (p1 < p2) {
                    if(nums[p1]<nums[p2]) return nums[p1];
					mid = p1 + ( p2 - p1 ) /2;
					//if(nums[p2] < nums[mid]) {
					//	p1 = mid+1;
						
						
					//}else {
					//	p2 = mid;
					//}
                    if(nums[mid] >= nums[p1]){
                        p1 = mid + 1 ;
                    }else{
                        p2 = mid;
                    }
				}
				return nums[p1];
				 * */
				
				
				return nums[p2];
    }
		public static void main(String[] args) {
			int[] nums = {7,6,5,4,3,2,1,0};
			int res = findMin(nums);
			System.out.println(res);
		}
}
