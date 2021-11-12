package javaDailyProctice.Test1112;

import java.util.Arrays;

public class Test1112_1 {
    public static void main(String[] args) {
        int[] arr={13,1,5,7,14,99};
        HeapShuffer(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void HeapShuffer(int[] arr) {
        for(int i=arr.length-1;i>=0;i--){
            ShiftDown(arr,i,arr.length);
        }
        int heapsize=arr.length;
        for(int i=0;i<arr.length;i++){
            int tmp=arr[0];
            arr[0]=arr[heapsize-1];
            arr[heapsize-1]=tmp;
            heapsize--;
            ShiftDown(arr,0,heapsize);
        }
    }

    private static void ShiftDown(int[] arr, int i, int size) {
        int parent=i;
        int child=2*parent+1;
        while (child<size){
            if(child+1<size && arr[child]<arr[child+1]){
                child=child+1;
            }
            if(arr[parent]<arr[child]){
                int tmp=arr[parent];
                arr[parent]=arr[child];
                arr[child]=tmp;
            }else {
                break;
            }
            parent=child;
            child=parent*2+1;
        }
    }
}
