package selfmade;

public class Code_00_BubbleSort {
    public static void main(String[] args) {
        int arr[] = {5,2,6,7,3,1,4};
        for(int i : arr) {
            System.out.print(i+"");
        }
        System.out.println();
        System.out.println("========");
        bubbleSort(arr);
        for(int i : arr) {
            System.out.print(i+"");
        }
    }

    public static void bubbleSort(int[] arr){
        for(int index =arr.length - 1;index>0;index--){
            for (int i = 0; i < index ; i++) {
                if(arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;



    }

}
