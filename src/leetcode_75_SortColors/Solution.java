package leetcode_75_SortColors;

/*荷兰国旗问题，使用快速排序的partition过程快速求解
 * 注意大于区小于区移动时，cur指针移动还是保持原位
 * 注意if else多个判断的写法，不要写成多个if*/

public class Solution {
		public static void sortColors(int[] nums) {
			if(nums == null) {
				return ;
			}
			
			int left = -1;
			int right = nums.length;
			int pivot = 1;
			int cur = 0;
			while( cur <right) {
				if(nums[cur] < pivot ) {
					swap(nums,cur,left+1);
					left++;
					cur++;
					//swap(arr, ++less, l++)
				}else if(nums[cur] > pivot) {
					swap(nums,cur,right-1);
					right--;
				}else {
					cur++;
					
					
				}
				
			}
    }
		public static void swap(int[] arr,int i ,int j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
			
		}
		public static void main(String[] args) {
			int[] arr = new int[] {2,0,2,1,10};
			sortColors(arr);
			
		}
}
