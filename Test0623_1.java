package javaDailyProctice.Test0623;


import java.util.Scanner;


/**
 * 链接：https://www.nowcoder.com/questionTerminal/02d8d42b197646a5bbd0a98785bb3a34
 * 来源：牛客网
 *
 * A,B,C三个人是好朋友,每个人手里都有一些糖果,我们不知道他们每个人手上具体有多少个糖果,但是我们知道以下的信息：
 * A - B, B - C, A + B, B + C. 这四个数值.每个字母代表每个人所拥有的糖果数.
 * 现在需要通过这四个数值计算出每个人手里有多少个糖果,即A,B,C。这里保证最多只有一组整数A,B,C满足所有题设条件。
 */
public class Test0623_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            int d=sc.nextInt();
             double x,y,z,yl;
             int x1,y1,z1;
             //依据题意建立方程组
             x=(a+c)/2.0;
             y=(b+d)/2.0;
             yl=(c-a)/2;
             z=(d-b)/2.0;
             //用于校验结果的 得到的结果必须是整数才行
             x1=(a+c)/2;
             y1=(b+d)/2;
             z1=(d-b)/2;
            if((x-x1<=0 && x1-x<=0) && (y-y1<=0 && y1-y<=0) &&  (z-z1<=0 && z1-z<=0) && (yl-y<=0 && y-yl<=0) ){
                    System.out.println(x1+" "+y1+" "+z1);
            }else {
                System.out.println("No");
            }
        }

    }
}
