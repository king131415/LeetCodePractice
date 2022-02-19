import java.util.Arrays;

/**
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *你可以返回满足此条件的任何数组作为答案。
 *
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 */
public class Test0219_1 {
    public static void main(String[] args) {
        int[] arr={3,1,2,4};
         sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr) {
        int tmp=0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]%2!=0 && arr[j+1]%2==0){
                    tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
    }
}
