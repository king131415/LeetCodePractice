package javaDailyProctice.Test0108;

import java.util.Arrays;

public class Test0108_2 {
    public static void main(String[] args) {
        int[] arr={3,5,8,1,9,22};
        maoPaoShuff(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void maoPaoShuff(int[] arr) {
        for(int i=0;i<arr.length-1;i++){
            for(int j=i;j<arr.length-1-i;j++){
                if(arr[j]<arr[j+1]){
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
    }
}
