package javaDailyProctice;

/**
 * S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 *
 * "ab##"
 * "c#d#"
 *  "ab#c", T = "ad#c"
 *
 *  "a##c"
 * "#a#c"
 */
public class Test0418 {
    public static void main(String[] args) {
        String S="a##c";
        String T="#a#c";
       boolean result= backspaceCompare(S,T);
        System.out.println(result);
    }
    public static boolean backspaceCompare(String S, String T) {
          if(S.equals(T)){  //如果相等就直接返回True
              return true;
          }
          //将字符串转化为可变字符串
          StringBuffer S1=new StringBuffer(S);
          StringBuffer T1=new StringBuffer(T);
          String S2="";
          String T2="";
          for(int i=0;i<S1.length();i++){  //"ab##"
              if(S1.charAt(i)=='#'){
                  if(i!=0){
                    S1.deleteCharAt(i-1);
                    i=i-1;
                  }
                  S1.deleteCharAt(i);
                  i=-1;  //删除字符串后让下标从零开始
              }
          }
          S2=S1.toString();
          for (int i=0;i<T1.length();i++){
              if(T1.charAt(i)=='#'){
                  if(i!=0){
                      T1.deleteCharAt(i-1);
                      i=i-1;
                  }
                  T1.deleteCharAt(i);
                  i=-1;
              }
          }
          T2=T1.toString();
          if(S2.equals(T2)){
              return true;
          }
          return false;
    }
}
