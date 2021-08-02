package javaSePrictice;

/**
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * 示例 1：
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 示例 2：
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 示例 3：
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 */
public class Test0802_2{
    public static void main(String[] args) {
          int[] arr={3,2,1};
          int result=thirdMax(arr);
          System.out.println(result);
    }
    public static int thirdMax(int[] nums) {
         for(int i=0;i<nums.length-1;i++){    //排序
             for(int j=0;j<nums.length-i-1;j++){
                 int tmp=0;
                 if(nums[j]<nums[j+1]){
                     tmp=nums[j];
                     nums[j]=nums[j+1];
                     nums[j+1]=tmp;
                 }
             }
         }
         int pos=0;
         for(int i=0;i<nums.length-1;i++){  //寻找第三大数
                 if(nums[i]!=nums[i+1]){
                     pos++;
                 }
                 if(pos==2){
                     return nums[i+1]; //找到了第三大数，直接返回
                 }
         }
         return nums[0]; //没找到，放回最大数
    }
}
