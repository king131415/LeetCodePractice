package javaDailyProctice.Test1109;

import java.util.Arrays;

public class Test11_09 {
    public static void main(String[] args) {
        int[] arr={1,8,4,90,21,3,4,5};
        KuiShuffer(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void KuiShuffer(int[] arr) {
        _QuikSort(arr,0,arr.length-1);
    }

    private static void _QuikSort(int[] arr, int left, int right) {
        if(left>=right){
            return;
        }
        int index=partion(arr,left,right);
        _QuikSort(arr,0,index-1);
        _QuikSort(arr,index+1,right);

    }

    private static int partion(int[] arr, int left, int right) {
        int data=arr[left]; //基准值
        int l=left;
        int r=right;
        while (l<r){
            while (l<r && arr[r]>=data){
                r--;
            }
            while (l<r && arr[l]<=data){
                l++;
            }
            int tmp=arr[l];
            arr[l]=arr[r];
            arr[r]=tmp;
        }
        int tmp=arr[left];
        arr[left]=arr[l];
        arr[l]=tmp;
        return l;
    }
}
