package javaDailyProctice.Test0111;

import java.util.Arrays;

public class Test0112_1 {
    public static void main(String[] args) {
        int[] arr={2,55,3,1,8,9,4,6};
        mergerSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergerSort(int[] arr) {
        _mergersort(arr,0,arr.length);


    }

    private static void _mergersort(int[] arr, int left, int right) {
        if(right-left<=1){
            return;
        }
        int mid=(right+left)/2;
        _mergersort(arr,left,mid);
        _mergersort(arr,mid,right);
        merge(arr,left,mid,right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int cur1=left;
        int cur2=mid;
        int[] tmp=new int[right-left];
        int index=0;
        while (cur1< mid && cur2<right){
            if(arr[cur1]>arr[cur2]){
                tmp[index]=arr[cur2];
                index++;
                cur2++;
            }else {
                tmp[index]=arr[cur1];
                index++;
                cur1++;
            }
        }
        while (cur1<mid){
            tmp[index]=arr[cur1];
            index++;
            cur1++;
        }
        while (cur2<right){
            tmp[index]=arr[cur2];
            index++;
            cur2++;
        }
        for(int i=0;i<tmp.length;i++){
            arr[i+left]=tmp[i];
        }
    }
}
