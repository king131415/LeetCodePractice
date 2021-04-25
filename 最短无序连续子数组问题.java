package javaSePrictice;


import java.util.Arrays;

/**
 *给你一个整数数组 nums ，你需要找出一个 连续子数组 ;
 * 如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * 示例 1：
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 * 输入：nums = [1]
 * 输出：0
 */
public class 最短无序连续子数组问题 {
    public static void main(String[] args) {
        int[] nums={2,6,4,8,10,9,15};
        int result=findUnsortedSubarray(nums);
        System.out.println(result);

    }
    public static int findUnsortedSubarray(int[] nums) {
        if(nums.length==1){
            return 0;
        }
          int count=0;
          for(int i=0;i<nums.length-1;i++){ //判断原来数组是否是已经有序的
              if(nums[i]<=nums[i+1]){    //防止出现重复的元素==》"<="
                  count++;
              }
          }
          if(count==nums.length-1){  //如果相等说明原来数组是有序的
              return 0;
          }
        int[] arr=new int[nums.length];  //复制原来的数组
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
        }
        int i=0;
        int j=nums.length-1;
        Arrays.sort(nums);    //对原来的数组进行升序排序
        while (i<j){
            if(arr[i]==nums[i]){
                i++;
            }
            if(arr[j]==nums[j]){
                j--;
            }
            if(arr[i]!=nums[i] && arr[j]!=nums[j]){
                break;
            }
        }
        return j-i+1;
    }
}
