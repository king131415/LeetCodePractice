package javaDailyProctice.Test0623;

import java.util.Scanner;

/**
 * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数待解决
 */

public class Test0623_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
            int a=sc.nextInt();
            int b=sc.nextInt();
            StringBuilder bd=new StringBuilder();
            while (true){
                int x=a%b;
                bd.append(x);
                a=a/b;
                if(a==0){
                    break;
                }

            }

        System.out.println(bd.reverse());

    }
}
