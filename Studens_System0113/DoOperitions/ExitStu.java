package javaDailyProctice.Studens_System0113.DoOperitions;

import javaDailyProctice.Studens_System0113.StudentsList;

import java.io.IOException;

public class ExitStu implements DoOperition{
    @Override
    public void work(StudentsList studentsList) throws IOException, ClassNotFoundException {
        System.out.println("安全退出系统成功！");
        System.exit(0);
    }
}
