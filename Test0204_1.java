import java.util.Arrays;

/**
 * 给你一个整数数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 *  数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。
 *  如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。
 *  注意：中心索引可能出现在数组的两端。
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心索引是 3 。
 * 左侧数之和 (1 + 7 + 3 = 11)，
 * 右侧数之和 (5 + 6 = 11) ，二者相等。
 */
public class Test0204_1 {
    public static void main(String[] args) {
        int[] nums={1, 7, 3, 6, 5, 6};
        int result=pivotIndex(nums);
        System.out.println(result);
    }
    public static  int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();  //数组所有元素求和
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) { //循环遍历数组
            if (2 * sum + nums[i] == total) { //左侧元素和为sun如果和右侧元素total-sum-nums[i]相等即返回i
                return i;
            }
            sum += nums[i];
        }
        return -1; //没有找到
    }
}
