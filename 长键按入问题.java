package javaSePrictice;

public class 长键按入问题 {
    public static void main(String[] args) {
        String name="alex";
        String typed="aaleex";
        boolean result=isLongPressedName(name,typed);
        System.out.println(result);
    }
    public static boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        StringBuffer str1=new StringBuffer(name);
        StringBuffer str2=new StringBuffer(typed);
        while (j < str2.length()) { //遍历typed
            if (i < str1.length() && str1.charAt(i) == str2.charAt(j)) {  //如果当前两个字符存在一对一匹配,下标都加1
                i++;
                j++;

            } else if (j > 0 && str2.charAt(j) == str2.charAt(j-1)) { //如果按下的字符和前一个相等，就单独的J加1
                j++;
            } else {
                return false;
            }
        }
        return i == str1.length(); //如果遍历完后i与str1的长度相等，说明str2存在与str1相匹配的字符
    }
}
