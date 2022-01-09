package javaDailyProctice.Test20220109;

import java.util.Arrays;

public class Test0109_2 {
    public static void main(String[] args) {
        int[] arr={54,21,-2,12,2,3,1,6};
        HeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void HeapSort(int[] arr) {
        for(int i=arr.length-1;i>=0;i--){
            shiftDowm(arr,i,arr.length);
        }
        int heapsize=arr.length;
        for(int i=0;i<arr.length;i++){
            int tmp=arr[0];
            arr[0]=arr[heapsize-1];
            arr[heapsize-1]=tmp;
            heapsize--;
            shiftDowm(arr,0,heapsize);
        }
    }

    private static void shiftDowm(int[] arr, int i, int size) {
        int parent=i;
        int child=2*i+1;
        while (child<size){
            if(child+1<size && arr[child+1]<arr[child]){
                child=child+1;
            }
            if(arr[parent]>arr[child]){
                int tem=arr[child];
                arr[child]=arr[parent];
                arr[parent]=tem;
            }else { //减少循环次数
                break;
            }
            //更新位置
            parent=child;
            child=parent*2+1;
        }
    }
}
