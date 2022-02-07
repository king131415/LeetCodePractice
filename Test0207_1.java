import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/18ecd0ecf5ef4fe9ba3f17f8d00d2d66
 * 来源：牛客网
 *
 * Fibonacci数列是这样定义的：
 * F[0] = 0
 * F[1] = 1
 * for each i ≥ 2: F[i] = F[i-1] + F[i-2]
 * 因此，Fibonacci数列就形如：0, 1, 1, 2, 3, 5, 8, 13, ...，
 * 在Fibonacci数列中的数我们称为Fibonacci数。给你一个N，你想让其变为一个Fibonacci数，
 * 每一步你可以把当前数字X变为X-1或者X+1，现在给你一个数N求最少需要多少步可以变为Fibonacci数。
 *
 * 输入描述:
 * 输入为一个正整数N(1 ≤ N ≤ 1,000,000)
 */
public class Test0207_1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int a=0;
        int b=1;
        while (b<=N){ //输入的这个数跳出出循环后必定在最近的两个斐波拉契数之间
            int b_temp=a+b;   //循环找斐波拉契额数
            a=b;
            b=b_temp;
        }
        System.out.print((b-N)>(N-a)?N-a:b-N);  //做出比较找出最短的路径
    }
}
