package javaDailyProctice.Test1113_1;

import java.util.Arrays;

public class Test1113_4 {
    public static void main(String[] args) {
        int[] arr={65,13,67,141,90};
        maoPao(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void maoPao(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
    }
}
