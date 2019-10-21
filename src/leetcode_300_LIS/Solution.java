package leetcode_300_LIS;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int res = 0;

        for ( int i = 0; i < nums.length ; i++ ){
            for( int j = 0;j < i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);

                }
            }

            res = Math.max(res,dp[i]);
        }


    return res;
    }


    public int lengthOfLIS1(int[] nums) {

        int[] help = new int[nums.length];
        if (nums.length <= 1) {
            return nums.length;
        }
        help[0] = nums[0];
        int end = 1;


        for (int i = 1; i < nums.length; i++) {
            int left = 0;
            int right = end;
            while (left < right) { //二分查找到第一个大于等于nums[i]的元素的逻辑
                int mid = (left + right) >>> 1;
                if (nums[i] < help[mid]) {
                    right = mid;
                } else if (nums[i] == help[mid]) {
                    right = mid;
                } else if (nums[i] > help[mid]) {
                    left = mid + 1;
                }
            }
            help[left] = nums[i];
            if (left == end) {
                end++;
            }
        }

        return end;
    }

    public static void main(String[] args) {
        Solution s1 = new Solution();
        int[] arr = {4,10,4,3,8,9};
        int res = s1.lengthOfLIS1(arr);
        System.out.println(res);
    }
}
