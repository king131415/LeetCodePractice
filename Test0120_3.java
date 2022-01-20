
/**
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test0120_3 {
    public static void main(String[] args) {
        int[] num={-4,-1,0,3,10};
        int[] num1=sortedSquares(num);
        for(int i:num1){
            System.out.println(i);
        }

    }
    public static int[] sortedSquares(int[] nums) {
            for(int i=0;i<nums.length;i++){
                nums[i]=nums[i]*nums[i];
            }
            int tmp=0;
            for(int j=0;j<nums.length-1;j++){
                for(int k=0;k<nums.length-j-1;k++){
                    if (nums[k] > nums[k+1]) {
                        tmp=nums[k];
                        nums[k]=nums[k+1];
                        nums[k+1]=tmp;
                    }
                }
            }
            return nums;
    }
}
