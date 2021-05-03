package javaSePrictice;

/**
 * 给定一个字符串 S，返回 “反转后的” 字符串，
 * 其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 * 示例 1：
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 */

public class 仅仅反转字母问题 {
    public static void main(String[] args) {
           String S="Test1ng-Leet=code-Q!";
                    //"Qedo1ct-eeLg=ntse-T!"
         String str1=reverseOnlyLetters(S);
        System.out.println(str1);
    }
    public  static String reverseOnlyLetters(String S) {
        char[] c = S.toCharArray();
        int l=0,r = c.length-1;//左指针，右指针
        while(l<r){
            if(!cal(c[l])){
                ++l;    //不是字符左指针右移
            }
            if(!cal(c[r])) {
                --r;   //不是字符右指针左移
            }
            if(cal(c[l])&&cal(c[r])){//同时是字母对调
                char t=c[l];
                c[l]=c[r];
                c[r]=t;
                l++; //更新下标位置
                r--; //更新下标位置
            }
        }
        return new String(c);
    }
    //判断是否是字母，是字母返回ture
    private static boolean cal(char c){
        return ((65<=c&&c<=90)||(97<=c&&c<=122)) ? true : false;
    }
}



