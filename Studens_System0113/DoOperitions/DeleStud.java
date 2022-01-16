package javaDailyProctice.Studens_System0113.DoOperitions;

import javaDailyProctice.Studens_System0113.Student;
import javaDailyProctice.Studens_System0113.StudentsList;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class DeleStud implements DoOperition{
    @Override
    public void work(StudentsList studentsList) throws IOException, ClassNotFoundException {
        OutputStream outputStream=null;
        ObjectOutputStream os=null;
        try {
            List<Student> students = studentsList.getStudents();
            Scanner scanner=new Scanner(System.in);
            System.out.println("请输入你要删除的学生的ID");
            int DeleId=scanner.nextInt();
            InputStream inputStream=new FileInputStream("D://Students.txt");
            ObjectInputStream in=new ObjectInputStream(inputStream);
            students = (List<Student>)in.readObject();
            for(int i=0;i<students.size();i++){
                if(students.get(i).getId()==DeleId){
                    students.remove(i);
                    outputStream=new FileOutputStream("D://Students.txt");
                    os=new ObjectOutputStream(outputStream);
                    os.writeObject(students);
                    outputStream.flush();
                    os.flush();
                    System.out.println("删除成功！！");
                    return;
                }
            }

        }finally {
           outputStream.close();
           os.close();
        }

        System.out.println("没有此学生！！！");
    }
}
