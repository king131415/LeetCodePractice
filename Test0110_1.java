package javaDailyProctice.Test20220109;

import java.util.Arrays;

public class Test0110_1 {
    public static void main(String[] args) {
        int[] arr={32,5,66,7,-1,1};
        QuckSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void QuckSort(int[] arr) {
        _quickSort(arr,0,arr.length-1);
    }

    private static void _quickSort(int[] arr, int left, int right) {
        if(left>=right){
            return;
        }
        int index=partion(arr,left,right);
        _quickSort(arr,left,index-1);
        _quickSort(arr,index+1,right);

    }

    private static int partion(int[] arr, int left, int right) {
        int data=arr[right];
        int cur1=left;
        int cur2=right;
        while (cur1<cur2){
            while (cur1<cur2 && arr[cur1]<=data){
                cur1++;
            }
            while (cur1<cur2 && arr[cur2]>=data){
                cur2--;
            }
            int tmp=arr[cur1];
            arr[cur1]=arr[cur2];
            arr[cur2]=tmp;
        }
        int tmp=data;
        arr[right]=arr[cur1];
        arr[cur1]=tmp;
        return cur1;

    }
}
