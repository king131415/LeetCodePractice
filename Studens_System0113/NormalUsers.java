package javaDailyProctice.Studens_System0113;

import javaDailyProctice.Studens_System0113.DoOperitions.DoOperition;
import javaDailyProctice.Studens_System0113.DoOperitions.ExitStu;
import javaDailyProctice.Studens_System0113.DoOperitions.SearchStu;
import javaDailyProctice.Studens_System0113.DoOperitions.ShowAllStudents;

import java.io.IOException;

public class NormalUsers extends Users {
    public NormalUsers() {
        this.doOperitions=new DoOperition[]{
                new SearchStu(),
                new ShowAllStudents(),
                new ExitStu()
        };
    }

    @Override
    public void menue() {
        System.out.println("=============================");
        System.out.println("=======欢迎进入学生管理系统!=======");
        System.out.println("= 1.查看学生信息  2.查看学生列表信息=");
        System.out.println("========= 3.退出系统 ============");
        System.out.println("===============================");
    }

}
