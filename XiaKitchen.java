package Written_Question_Items;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 牛牛想尝试一些新的料理，每个料理需要一些不同的材料，问完成所有的料理需要准备多少种不同的材料。
 * 链接：https://www.nowcoder.com/questionTerminal/ca5c9ba9ebac4fd5ae9ba46114b0f476
 * 来源：牛客网
 *
 * 每个输入包含 1 个测试用例。每个测试用例的第 i 行，表示完成第 i 件料理需要哪些材料，
 * 各个材料用空格隔开，输入只包含大写英文字母和空格，输入文件不超过 50 行，每一行不超过 50 个字符。
 * 输出描述:
 * 输出一行一个数字表示完成所有料理需要多少种不同的材料。
 * 示例1
 * 输入
 * BUTTER FLOUR
 * HONEY FLOUR EGG
 */
public class XiaKitchen {
    /**
     * 其实就是找出重复的字符串
     * @param args
     */
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        HashSet<String> set=new HashSet<>();
        while (in.hasNext()){
            String str=in.nextLine();
            String [] a=str.split(" ");
            for (int i=0;i<a.length;i++){
                set.add(a[i]);
            }
        }
        System.out.print(set.size()); //输出set集合的大小即可,最后Ctrl+D结束输入

    }
}
