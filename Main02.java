package javaDailyProctice.Test1108;

import java.util.Arrays;

/**
 * 插入排序就是从后往前插
 */
public class Main02 {
    public static void main(String[] args) {
        int[] arr={2,8,7,98,1,6,5};
        shitShuffer(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shitShuffer(int[] arr) {
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
