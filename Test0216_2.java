public class Test0216_2 {
    public static void main(String[] args) {
// 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
               int a=12121;
               boolean b=panDuan(a);
               System.out.println(b);
    }
    public static boolean panDuan(int a) {
        int temp=a;
        if(a<0){   //小于零是构不成回文数的
            return false;
        }
        int pos=0;
        while (a!=0){
            pos=pos*10+a%10;  //若是回文数就是对称的通过和10取余得到个位，然后通过循环乘以10得到一个新得数
            a=a/10;
        }
        if(pos==temp){
            return true;
        }
        return false;
    }
}
