package javaDailyProctice.Test1108;

import java.util.Arrays;

public class Main01 {
    public static void main(String[] args) {
        int[] arr={2,8,7,98,1,6,5};
        maoShuffer(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void maoShuffer(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]<arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
