package javaDailyProctice.Test1112;

import java.util.Arrays;

public class Test1112_3 {
    public static void main(String[] args) {
        int[] arr={13,2,5,7,1,99}; // 2 5 1  7  13 99
        MaoPaoShuerff(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void MaoPaoShuerff(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
    }
}
