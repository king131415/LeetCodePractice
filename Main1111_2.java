package javaDailyProctice.Test1111;

import java.util.Arrays;

public class Main1111_2 {
    public static void main(String[] args) {
        int[] arr={5,6,80,26,87,1,77};
        HeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void HeapSort(int[] arr) {
        for(int i=arr.length-1;i>=0;i--){ //从后往前建堆
            ShifDown(arr,i,arr.length);
        }
        int heapSize=arr.length;
        for(int i=0;i<arr.length;i++){
            int data=arr[0];
            arr[0]=arr[heapSize-1];
            arr[heapSize-1]=data;
            heapSize--;
            ShifDown(arr,0,heapSize); //从零的位置开始向下调整
        }
    }

    private static void ShifDown(int[] arr, int i, int size) {
        int parent=i;
        int child=parent*2+1;
        while (child<size){
            if(child+1<size && arr[child]>arr[child+1]){
                child=child+1;
            }
            if(arr[parent]>arr[child]){
                int tmp=arr[parent];
                arr[parent]=arr[child];
                arr[child]=tmp;
            }else {
                break;
            }
            parent=child;
            child=2*parent+1;
        }
    }
}
