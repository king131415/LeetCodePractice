package javaDailyProctice.Studens_System0113;

import javaDailyProctice.Studens_System0113.DoOperitions.*;

import java.io.IOException;

public class Admin extends Users{
    public Admin() {
        this.doOperitions=new DoOperition[]{
                new AddOperitionStu(),
                new UpdateStu(),
                new SearchStu(),
                new ShowAllStudents(),
                new DeleStud(),
                new ExitStu()
        };
    }

    @Override
    public void menue() {
        System.out.println("=============================");
        System.out.println("=======欢迎进入学生管理系统!=======");
        System.out.println("= 1.添加学生信息  2.修改学生信息   =");
        System.out.println("= 3.查看学生信息  4.查看学生列表信息=");
        System.out.println("= 5.删除学生信息  6.退出系统      =");
        System.out.println("===============================");
    }

}
