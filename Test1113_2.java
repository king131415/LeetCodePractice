package javaDailyProctice.Test1113_1;

import java.util.Arrays;

public class Test1113_2 {
    public static void main(String[] args) {
        int[] arr={13,45,12,64,3};
        insertShuffer(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertShuffer(int[] arr) {
        for(int i=1;i<arr.length;i++){
            int j=i-1;
            int data=arr[i];
            for(;j>=0;j--){
                if(arr[j]>data){
                    arr[j+1]=arr[j];
                }else {
                    break;
                }
            }
            arr[j+1]=data;
        }
    }
}
