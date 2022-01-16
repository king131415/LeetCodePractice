package javaDailyProctice.Studens_System0113;

import java.io.IOException;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        StudentsList studentsList = new StudentsList();
        Menue();
        Scanner sc=new Scanner(System.in);
        int chioce=sc.nextInt();
        Users users=getUser(chioce);
        while (true){
            users.menue();
            int chices2=sc.nextInt();
            users.Works(studentsList,chices2);
        }



    }

    private static Users getUser(int chioce) {
        while (true){
            if(chioce==1){
                return new NormalUsers();
            }else if(chioce==2){
                return new Admin();
            }else {
                System.out.println("输入错误,继续输入！！");
            }
        }

    }

    public static void Menue(){
        System.out.println("=============================");
        System.out.println("=====欢迎进入学生信息管理系统=====");
        System.out.println("=== 1.普通用户    2.系统管理员===");
        System.out.println("=============================");
    }
}
