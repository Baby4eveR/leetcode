package selfmade;

public class Code_02_InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5,2,6,7,3,4,1};
       // insertionSort(arr);
        insertionSort2(arr);
        for (int i: arr) {
            System.out.print(i);
        }
    }

    public static void insertionSort(int[] arr){
        for(int start = 0;start < arr.length;start++){
            for(int end = start - 1 ; end >=0 ;end--){
                if(arr[end] > arr[end+1]){
                    swap(arr,end,end+1);
                }
            }
        }
    }
    public static  void insertionSort2(int[] arr){
        for(int start = 1;start <arr.length;start++){
            for(int order_end = start-1;order_end>=0 && arr[order_end]>arr[order_end+1];
                order_end--){
                swap(arr,order_end,order_end+1);
            }


        }


    }

    public static  void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;


    }
}
