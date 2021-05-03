package javaSePrictice;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。你可以按任意顺序返回答案。
 *示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 */
public class 两数之和问题 {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        int[] arr=twoSum(nums,6);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] twoSum(int[] nums, int target) {
               int[] arr1=new int[2]; //创建一个数组用来接收下标
               for(int i=0;i<nums.length-1;i++){
                   for(int j=i+1;j<nums.length;j++){
                       if (nums[i] + nums[j] == target) {
                           arr1[0]=i;
                           arr1[1]=j;
                          return arr1; //找到了直接返回
                       }
                   }
               }
               return null; //没找到
    }
}
