package javaDailyProctice.Test0108;

import java.util.Arrays;

public class Test0108_1 {
    public static void main(String[] args) {
        int[] arr={52,1,6,4,2,3};
        insertShuff(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void insertShuff(int[] arr) {
        for(int i=1;i<arr.length;i++){
            int v=arr[i];
            int j=i-1;
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
