import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。
 * 找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]
 */
public class Test0124_2 {
    public static void main(String[] args) {
        int[] nums={1,2,3,5,5,5,7};
         int[] arr=searchRange(nums,5);
        System.out.println(Arrays.toString(arr));
    }
    public static int[] searchRange(int[] nums, int target) {
       int left=0;
       int right=nums.length-1;
       while (left<right){
           if(nums[left]==target && nums[right]==target){
               return new int[]{left,right};
           }
           if(nums[left]!=target){
               left++;
           }
           if(nums[right]!=target){
               right--;
           }
       }
       return new int[]{-1,-1};
    }
}
