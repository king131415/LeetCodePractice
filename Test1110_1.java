package javaDailyProctice.Test1110;

import java.util.Arrays;

public class Test1110_1 {
    public static void main(String[] args) {
        int[] arr={5,4,1,6,9,10};
        guiShuffer(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void guiShuffer(int[] arr) {
        _guiSort(arr,0,arr.length);
    }

    private static void _guiSort(int[] arr, int left, int right) {
        if(right-left<=1){
            return;
        }
        int mid=(right-left)/2+left;
        _guiSort(arr,left,mid);
        _guiSort(arr,mid,right);
        _merger(arr,left,mid,right);
    }

    private static void _merger(int[] arr, int left, int mid, int right) {
        int cur1=left;
        int cur2=mid;
        int[] temp=new int[right-left];
        int index=0;
        while (cur1<mid && cur1<right){
            if(arr[cur1]<=arr[cur2]){
                temp[index++]=arr[cur1++];
            }else {
                temp[index++]=arr[cur2++];
            }
        }
        //左边是否有剩余
        while (cur1<mid){
            temp[index++]=arr[cur1++];
        }
        //右边是否有剩余
        while (cur2<right){
            temp[index++]=arr[cur2++];
        }
        for(int i=0;i<temp.length;i++){
            arr[left+i]=temp[i];
        }
    }
}
