package javaSePrictice;

/**
 * 给定一组字符，使用原地算法将其压缩。
 * 压缩后的长度必须始终小于或等于原数组长度。
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 * 在完成原地修改输入数组后，返回数组的新长度。
 * 输入：
 * ["a","a","b","b","c","c","c"]
 * 输出：
 * 返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
 * 说明：
 * "aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
 * 示例 2：
 * 输入：
 * ["a"]
 * 输出：
 * 返回 1 ，输入数组的前 1 个字符应该是：["a"]
 * 解释：
 * 没有任何字符串被替代。
 * 示例 3：
 * 输入：
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 输出：
 * 返回 4 ，输入数组的前4个字符应该是：["a","b","1","2"]。
 * 解释：
 * 由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
 * 注意每个数字在数组中都有它自己的位置。
 */
public class 压缩字符串问题 {
    public static void main(String[] args) {
        char[] chars={'a','a','b','b','c','c','c'};
        int result=compress(chars);
        System.out.println(result);
    }
    public static  int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < chars.length  ) { //循环遍历该字符串数组
            int count = 1;
            while (i < chars.length - 1  && chars[i] == chars[i + 1]) {
                i++;
                count++;
            }
            if (count == 1) {   //如果等于1就单独添加这个字符
                sb.append(chars[i]);
            } else if (count > 1) {  //如果大于1就添加这个字符和它出现的次数
                sb.append(chars[i]);
                sb.append(count);
            }
            i++;
        }
        char[] help = sb.toString().toCharArray();  //转换成字符数组
        for (int j = 0; j < help.length ; j++) {
            chars[j] = help[j];
        }
        return help.length;
    }
}
