package javaDailyProctice.Studens_System0113.DoOperitions;

import javaDailyProctice.Studens_System0113.Student;
import javaDailyProctice.Studens_System0113.StudentsList;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Scanner;

public class SearchStu implements DoOperition{
    @Override
    public void work(StudentsList studentsList) throws IOException, ClassNotFoundException {
        List<Student> students = studentsList.getStudents();
        Scanner  scanner=new Scanner(System.in);
        System.out.println("请输入你要查找学生的ID");
        int fiId= scanner.nextInt();
        InputStream inputStream=new FileInputStream("D://Students.txt");
        ObjectInputStream in=new ObjectInputStream(inputStream);
        students = (List<Student>)in.readObject();
        studentsList.setStudents(students);
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId()==fiId){
                System.out.println(students.get(i));
                return;
            }
        }
        System.out.println("没有此学生！！");

    }
}
