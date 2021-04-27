package javaSePrictice;

public class 字符串与数组 {
    public static void main(String[] args) {
//    实现函数 ToLowerCase() ，该函数接收一个字符串参数 str ，
//    并将该字符串中的大写字母转换成小写字母，之后返回新的字符串
        String str="ABCDEf";
//        int a=10;
//        字符串与数组  z=new 字符串与数组();
//        z.mychang();
//        System.out.println(字符串与数组.a);
        String str1= ToLowerCase(str);
        System.out.println(str1);
    }
   static void mychang(){
        int a=10;
        change(a);
    }
   static void change(int a){
        a=20;
    }
    public static String ToLowerCase(String str) {
        char[] arr1=str.toCharArray(); //将字符串转化成字符数组
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]>='A'&& arr1[i]<='Z'){
                arr1[i]+=32;
            }
        }
        return String.valueOf(arr1); //按照数组的内容放回成字符串
    }
}
