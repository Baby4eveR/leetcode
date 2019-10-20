package leetcode_33_SearchInRotatedSortedArray;
//此题旋转数组中没有重复数字
public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		if(null == nums) {
			return -1;
		}
		int start = 0;
        int end = nums.length-1;
        int mid = 0 ;
		while(start <= end) {
			mid = start + (end - start)/2;
			if(nums[mid] == target) {
				return mid;
			}
			if(nums[start] < nums[end]) {//说明此时数组完全没有旋转,直接按照有序数组的二分搜索来
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
			}else {
				if(nums[mid] >= target && target >= nums[start]) {
					end = mid;
				}else {
					start = mid + 1;
					
				}
			}
		}
		return -1;
	}
	public int search1(int[] nums, int target) {//这是自己写的第一版
        if(null == nums){
            return -1;
        }
        int start = 0;
        int end = nums.length-1;
        int mid = 0 ;
        while(start<= end){
            if(start == end ){
                if(nums[start] == target){
                    return start;
                }else{
                        break;
                            }
            }
            if(end - start == 1){
                if(nums[start] == target){
                    return start;
                }else if( nums[end] == target){
                    return end;
                }else{
                    break;
                }
            }
            mid = start + (end -start)/2;
            
            if(nums[mid] == target){
                return mid;
            }
          
            if(nums[start] <nums[end]){
                if(nums[mid] > target){
                    end = mid;
                }else{
                    start = mid + 1;
                }
               continue;
            }
            if(nums[start] > nums[mid]){
                if(nums[mid]>target){
                    end = mid ;
                }else if(nums[start] > target){
                    start = mid+1 ;
                }else{
                    end = mid ;
                }
                continue;
            }
            if(nums[start] < nums[mid]){
                if(nums[mid] <target){
                    start = mid+1 ;
                }else if(nums[start] > target){
                    start = mid+1 ;
                
                }else{
                    end = mid ;
                }
                continue;
            }
        }
        return -1;
    }
}
