package reverseOderArray;
//将数组的奇数全部放在偶数前面

import java.util.ArrayList;

public class Solution {
	public void reOrderArray(int [] array) {
		ArrayList<Integer> odd = new ArrayList<>();
		ArrayList<Integer> nodd = new ArrayList<>();
		for(int i =0;i<array.length;i++) {
			if(array[i]%2 == 0) {
				odd.add(array[i]);
			}else {
				nodd.add(array[i]);
			}
		}
		for(int i = 0;i<nodd.size();i++) {
			array[i] = nodd.get(i);
		}
		for(int j =0;j<odd.size();j++) {
			array[nodd.size()+j] = odd.get(j);
		}
		
	}
	
	public static void reOrderArray1(int [] array) {
		int left = 0;
		int right = array.length-1;
		while(left<right) {
			if(array[left]%2 == 0 && array[right]%2!=0) {
				swap(array,left,right);
				left++;
				right--;
			}else if(array[left]%2!=0) {
				left++;
			}else {
				right--;
			}
			
			
		}
	}
	public static  void reOrderArray2(int [] array) {
		int left = 0;
		int right = array.length-1;
		
		while(left<right) {
			while(array[left]%2!=0 && left < right) {
				left ++;
			}
			while(array[right]%2 ==0 && left < right) {
				right -- ;
			}
			if(left < right) {
				swap(array,left,right);
			}
			
		}
		
		
	}
	public static void swap(int[] arr,int i ,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void main(String[] args) {
		int[] array = {1,1,1};
		reOrderArray1(array);
		reOrderArray2(array);
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
	}
}
