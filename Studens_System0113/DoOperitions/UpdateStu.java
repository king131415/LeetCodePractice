package javaDailyProctice.Studens_System0113.DoOperitions;

import javaDailyProctice.Studens_System0113.Student;
import javaDailyProctice.Studens_System0113.StudentsList;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class UpdateStu implements DoOperition {
    @Override
    public void work(StudentsList studentsList) throws IOException, ClassNotFoundException {
        ObjectOutputStream os=null;
        OutputStream outputStream=null;
        try {
            System.out.println("请输入您要修改学生信息的学号！");
            Scanner scanner=new Scanner(System.in);
            int id= scanner.nextInt();
            List<Student> students = studentsList.getStudents();
            InputStream inputStream=new FileInputStream("D://Students.txt");
            ObjectInputStream in=new ObjectInputStream(inputStream);
            students=(List<Student>) in.readObject();
            for(int i=0;i<students.size();i++){
                if(students.get(i).getId()==id){
                    Student s=students.get(i);
                    System.out.println("请输入您要修改的ID:");
                    int upId=scanner.nextInt();
                    System.out.println("请输入要修改的age");
                    int upAge=scanner.nextInt();
                    System.out.println("请输入要修改的name");
                    String upname= scanner.next().trim();
                    s.setId(upId);
                    s.setAge(upAge);
                    s.setName(upname);
                    System.out.println("修改成功！");
                    studentsList.setStudents(students);
                    outputStream=new FileOutputStream("D://Students.txt");
                    os=new ObjectOutputStream(outputStream);
                    os.writeObject(students);
                    os.flush();
                    outputStream.flush();
                    return;
                }
            }

        }finally {
            os.close();
            outputStream.close();
        }
        System.out.println("没有此学生！！！");

    }
}
