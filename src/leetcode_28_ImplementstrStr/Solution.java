package leetcode_28_ImplementstrStr;

public class Solution {

    public int strStr(String haystack, String needle) {

            if(needle == null || needle.length() == 0) {return 0;};
            if(haystack.length() < needle.length()){
                return -1;
            }
            char[] source = haystack.toCharArray();
            char[] target = needle.toCharArray();

            int start = 0;
            // for( int i = 0; i < source.length - target.length ; i++ )
            for( int i = 0;i < source.length;i++){
                if(source[i] == target[0]){
                    start = i;
                    int j =0;
                    // i+j < source.length用于判断最后的长度要大于子串，可写到第一个for循环里
                    for( j = 0;j < target.length;j++){
                        if(i + j < source.length && source[i + j] == target[j]){
                            ;
                        }else {
                            break;
                        }

                    }
                    if(j == target.length){
                        return start;
                    }
                }


            }
            return -1;
    }
}
