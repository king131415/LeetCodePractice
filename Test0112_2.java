package javaDailyProctice.Test0111;

import java.util.Arrays;

public class Test0112_2 {
    public static void main(String[] args) {
        int[] arr={2,55,3,1,8,9,4,6};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void insertSort(int[] arr) {
        for(int i=1;i<arr.length;i++){
            int j=i-1;
            int v=arr[i];
            for(;j>=0;j--){
                if(arr[j]>v){
                    arr[j+1]=arr[j];
                }else {
                    break;
                }
            }
            arr[j+1]=v;
        }
    }
}
