package javaDailyProctice.Test1113_1;

import java.util.Arrays;

public class Test1113_3 {
    public static void main(String[] args) {
        int[] arr={13,45,12,64,3};
        heapShuufer(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void heapShuufer(int[] arr) {
        for(int i=arr.length-1;i>=0;i--){
            shiftDonm(arr,i,arr.length);
        }
        int heapsize=arr.length;
        for(int i=0;i<arr.length;i++){
            int tmp=arr[0];
            arr[0]=arr[heapsize-1];
            arr[heapsize-1]=tmp;
            heapsize--;
            shiftDonm(arr,0,heapsize);
        }
    }

    private static void shiftDonm(int[] arr, int i, int size) {
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
            }
            parent=child;
            child=parent*2+1;
        }
    }


}
