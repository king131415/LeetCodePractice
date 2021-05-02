package javaSePrictice;
public class 赎金信 {
    public static void main(String[] args) {
//    给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
//    判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；
//    否则返回 false。
        String ransom = "abc";
        String magazine = "abcde";
        boolean a = compared(ransom, magazine);
        System.out.println(a);
    }
    public static boolean compared(String ransom, String magazine) {
        char[] a1=ransom.toCharArray();  //把字符串转成数组
        char[] a2=magazine.toCharArray();
        if(a1.length>a2.length){
            return false;
        }
        int count=0;                      //定义一个计数器
        for(int i=0;i<a1.length;i++){    //循环遍历字符串转成数组的内容
            for(int j=0;j<a2.length;j++){
                if(a1[i]==a2[j]){
                    count+=1;      //在杂志字符数组中能找到一个赎金字符数组的字符就加一
                }
            }
        }
        if(count==a1.length){  //如果计数器的值和赎金字符数组的大小值一样，则说明在杂志字符串中可以找到组成赎金字符串的字符，所以就返回true
            return true;
        }
        return false;  //没找到
    }
}
