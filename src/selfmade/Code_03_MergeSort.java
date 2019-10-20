package selfmade;

public class Code_03_MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 7, 3, 4, 1};
        //mergeSort(arr);
        mergeSortUnrecur(arr);
        //insertionSort2(arr);
        for (int i : arr) {
            System.out.print(i);
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length < 2 || arr == null) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }
    public static void mergeSortUnrecur(int[] arr) {
        int start = 0;
        int end = arr.length - 1;//end已经减1了，min中不要再减1，已代表下标了；
        //主要考虑奇数情形，也就是最后所剩元素在step之内。
        for (int step = 1;step < arr.length ; step = step*2) {
            for (int i = start; i + step < arr.length; i = i + step*2 )
                merge(arr,i,i + step - 1,Math.min(end ,i + step*2 - 1));

        }
        /*
        while (len <= t.length) {
            for (int i = 0; i + len <= t.length - 1; i += len * 2) {
                //    System.out.println("len="+len);
                low = i;
                mid = i + len - 1;
                high = i + len * 2 - 1;
                if (high > t.length - 1)
                    high = t.length - 1;
                merge(t, i, mid, high);
            }
                //长度加倍
            len += len;
        }*/

    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] help = new int[end - start + 1];
        int p1 = start;
        int p2 = mid + 1;
        int index = 0;
        while (p1 <= mid && p2 <= end) {
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[index++] = arr[p1++];
        }

        while (p2 <= end) {
            help[index++] = arr[p2++];
        }

        for (index = 0; index < help.length; index++) {
            arr[start + index] = help[index];
        }
    }


}
