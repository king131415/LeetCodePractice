package javaDailyProctice.Test1109;

import java.util.Arrays;


//归并
public class Test1109_1 {
    public static void main(String[] args) {
        int[] arr={2,8,6,9,10,6,18};
        guiShuffer(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void guiShuffer(int[] arr) {
        _guiSort(arr,0,arr.length);
    }

    private static void _guiSort(int[] arr, int left, int rigt) {
        if(rigt-left<=1){
            return;
        }
        int mid=(left+rigt)/2;
        _guiSort(arr,left,mid);
        _guiSort(arr,mid,rigt);
        merger(arr,left,mid,rigt);
    }

    private static void merger(int[] arr, int left, int mid, int rigt) {
        int l=left;
        int r=mid;
        int[] temp=new int[rigt-left];
        int index=0;
        while (l<mid && r<rigt){
            if(arr[l]<=arr[r]){
                temp[index]=arr[l];
                index++;
                l++;
            }else {
                temp[index]=arr[r];
                index++;
                r++;
            }
        }
        while (l<mid){
            temp[index]=arr[l];
            index++;
            l++;
        }
        while (r<rigt){
            temp[index]=arr[r];
            index++;
            r++;
        }
        for(int i=0;i<temp.length;i++){
            arr[left+i]=temp[i];

        }
    }
}
