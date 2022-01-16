package javaDailyProctice.Studens_System0113.DoOperitions;

import StudentSystem.student;
import javaDailyProctice.Studens_System0113.Student;
import javaDailyProctice.Studens_System0113.StudentsList;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ShowAllStudents implements DoOperition {
    @Override
    public void work(StudentsList studentsList) throws IOException, ClassNotFoundException {
        List<Student> students = studentsList.getStudents();
        System.out.println("您的查询结果如下:");
        InputStream inputStream= new FileInputStream("D://Students.txt");
        ObjectInputStream in=new ObjectInputStream(inputStream);
        students=(List<Student>) in.readObject();
        studentsList.setStudents(students);
        for(int i=0;i<students.size();i++){
            System.out.println(students.get(i));
        }
    }
}
