package javaDailyProctice.Studens_System0113;

import java.io.*;

public class Test0113 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s=new Student();
        s.setId(01);
        s.setName("哈哈！");
        s.setAge(20);
        Student s1=new Student();
        s.setId(02);
        s.setName("afa");
        s.setAge(21);

        //用集合解决
        OutputStream os=new FileOutputStream("D://Students.txt",true);
        ObjectOutputStream os1=new ObjectOutputStream(os);
        os1.writeObject(s);
        os1.writeObject(s1);
        os1.flush();
        os1.close();
        System.out.println("=========成功了！===========");
        InputStream is=new FileInputStream("D://Students.txt");
        ObjectInputStream is1=new ObjectInputStream(is);
        Student so = (Student) is1.readObject();
        System.out.println(so);
    }
}
