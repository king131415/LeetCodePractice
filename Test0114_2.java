import java.util.*;
public class Test0114_2 {
    //汽水瓶问题
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                int num = sc.nextInt();
                if(num == 0 || num < 1 || num > 100)
                    break;
                int m = num / 3;
                int n = num % 3;
                int count = m;
                while(m > 0){
                    int temp1 = m;
                    int temp2 = n;
                    m = (temp1 + temp2) / 3;
                    n = (temp1 + temp2) % 3;
                    count += m;
                }
                if(m == 0 && n == 2)
                    count++;
                System.out.println(count);
            }
            sc.close();
        }
}
