package selfmade;

public class Code_01_SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,2,6,7,3,1,4};
        selectionSort(arr);
        for (int i: arr) {
            System.out.print(i);
        }
    }

    public static void selectionSort(int[] arr){
        for (int index = arr.length-1; index > 0 ; index--) {
            int minIndex = index;
            for(int i = index;i >= 0;i--){
                /*
                if(arr[i] < arr[minIndex]){
                    minIndex = i;
                }

                 */

                minIndex = arr[i] < arr[minIndex] ? i : minIndex;
            }
            swap(arr,index,minIndex);
        }
    }
    public static void swap(int[] arr,int i,int j){
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
    }
}
