import java.util.Scanner;
public class Q36 {
	    public static void main(String[] args) {
			
		
	        Scanner sc = new Scanner(System.in);
	        //获取输入的整数序列
	        String str = sc.nextLine();
	        String[] strings = str.split("，");
	        //转为整数数组
	        int[] arr = new int[strings.length];
	        for (int i = 0; i < strings.length; i++) {
	            arr[i] = Integer.parseInt(strings[i]);
	        }
	        System.out.println();
	       // int res = InversePairs(arr)%1000000007;
	       // System.out.println(res);

	        
	        
	    }
	    public static int InversePairs(int [] array) {
	        if(array == null || array.length< 2){
	            return 0;
	        }
	        return sortProcess(array,0,array.length-1);
	    }
	    public static int sortProcess(int[] arr,int start,int end){
	        if(start == end) return 0;
	        int mid = start + ((end - start)>>1);
	        
	        sortProcess(arr,start,mid);
	        sortProcess(arr,mid+1,end);
	        return merge(arr,start,mid,end);
	        
	        
	    }
	    public static int merge(int[] arr,int start,int mid,int end){
	        int p1 = start;
	        int p2 = mid +1;
	        int i = 0;
	        int[] help = new int[end-start+1];
	        int res = 0;
	        
	        while(p1<=mid && p2 <= end){
	            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
	            res+= arr[p1] > arr[p2] ? 1 : 0;
	    
	        }
	        
	        while(p1<=mid){
	            help[i++] = arr[p1++];
	            
	        }
	        while(p2<=end){
	            help[i++] = arr[p2++];
	        }
	        
	        for(i = 0;i<help.length;i++){
	            arr[start+i] = help[i];
	        }
	        
	        return res;
	        
	    }
	}

