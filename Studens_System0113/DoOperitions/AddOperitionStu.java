package javaDailyProctice.Studens_System0113.DoOperitions;

import javaDailyProctice.Studens_System0113.Student;
import javaDailyProctice.Studens_System0113.StudentsList;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class AddOperitionStu implements DoOperition{
    @Override
    public void work(StudentsList studentsList) throws IOException {
        List<Student> students = studentsList.getStudents();
        OutputStream outputStream=null;
        ObjectOutputStream os=null;
        try {
            Scanner sc=new Scanner(System.in);
            System.out.println("请您输入学生的学号:");
            int id=sc.nextInt();
            System.out.println("请您输入学生的姓名:");
            String name=sc.next().trim();
            System.out.println("请您输入学生的年龄:");
            int age=sc.nextInt();
            Student s=new Student();
            s.setId(id);
            s.setName(name);
            s.setAge(age);
            students.add(s);
            outputStream=new FileOutputStream("D://Students.txt");
            os=new ObjectOutputStream(outputStream);
            os.writeObject(students);
            os.flush();
            outputStream.flush();
            System.out.println("添加成功！！");
            return;
        }catch (Exception e){
            System.out.println("添加失败！！！");
            return;
        }finally {
            os.close();
            outputStream.close();
        }

    }
}
