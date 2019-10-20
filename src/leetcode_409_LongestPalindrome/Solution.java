package leetcode_409_LongestPalindrome;

public class Solution {
    public int longestPalindrome1(String s){
        int result = 0;
        int[] count = new int[128];

        for(char ch : s.toCharArray()){
            count[ch]++;


        }

        boolean flag = false;

        for(int i : count){
            if(i%2 == 0) {
                result = result + i;
            }else if(i%2 == 1){
                result = result + i/2;
                flag = true;
            }
        }

        return flag ? result + 1:result;
    }

    public int longestPalindrome(String s){
        int result = 0;
        int[] count = new int[128];

        for(char ch : s.toCharArray()){
            count[ch]++;


        }

        for(int i : count){
            result = result + i/2*2;
            if(i%2 == 1 && result%2 == 0){
                result ++;
            }
        }

        return result;
    }
// TODO: 2019/10/14

    public static void main(String[] args) {
        Solution s = new Solution();
        s.longestPalindrome("asdasdasdadwdfef");
    }

}

