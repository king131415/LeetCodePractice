package javaDailyProctice.Test1111;

import java.util.Arrays;

public class Main1111_1 {
    public static void main(String[] args) {
        int[] arr={5,6,80,26,87,1,77};
        ShellShuffer(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void ShellShuffer(int[] arr) {
        int gap=arr.length/2;
        while (gap>=1){
            for(int i=gap;i<arr.length;i++){
                int j=i-gap;
                int v=arr[i];
                for(;j>=0;j-=gap){
                    if(arr[j]>v){
                        arr[j+gap]=arr[j];
                    }else {
                        break;
                    }
                }
                arr[j+gap]=v;
            }
            gap=gap/2;
        }
    }
}
