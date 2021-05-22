package javaDailyProctice.Test0522;

import java.util.Scanner;

public class Test0522_1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            StringBuilder result = new StringBuilder();
            while (sc.hasNext()) {
                String str = sc.nextLine();
                for (int i = 0;i<str.length();i++) {
                    if (str.charAt(i) >= 'A' && str.charAt(i) <='E') {
                        result.append((char)(str.charAt(i)+21));
                    }else if(str.charAt(i) > 'E' && str.charAt(i) <='Z') {
                        result.append((char)(str.charAt(i) - 5));
                    }else if (str.charAt(i) == ' ') {
                        result.append(' ');
                    }
                }
                System.out.println(result);
                result.setLength(0);
            }
        }
}

