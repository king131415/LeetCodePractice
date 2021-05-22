package javaDailyProctice.Test0522;

import java.util.Scanner;

public class Test0522_2 {
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            while (input.hasNext()) {
                int n = input.nextInt();
                if (isPrimer(n)) {
                    System.out.println(1);
                    continue;
                }
                int cnt = 0;
                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        while (n % i == 0) {
                            n /= i;
                        }
                        cnt++;
                    }
                }
                if (n != 1) cnt++;
                System.out.println(cnt);
            }
        }

        public static boolean isPrimer(int n) {
            for (int i = 2; i <= Math.pow(n, 0.5); i++) {
                if (n % i == 0) return false;
            }
            return true;
        }
}
