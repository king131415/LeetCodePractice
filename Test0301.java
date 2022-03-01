import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 * 输入：digits = [0]
 * 输出：[1]
 */
public class Test0301 {
    public static void main(String[] args) {
        int[] digits={9,9,9,9,9};
        int[] arr=plusOne(digits);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] plusOne(int[] digits) {
            for(int i=digits.length-1;i>=0;i--){//循环遍历每一位数，看是否为9
                if(digits[i]==9){
                    digits[i]=0;
                }else {
                    digits[i]=digits[i]+1;
                    return digits;
                }
            }
             digits=new int[digits.length+1];
             digits[0]=1;
             return digits;
    }
}
