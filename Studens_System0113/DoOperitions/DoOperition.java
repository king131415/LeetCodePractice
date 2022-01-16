package javaDailyProctice.Studens_System0113.DoOperitions;

import StudentSystem.Students;
import javaDailyProctice.Studens_System0113.StudentsList;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface DoOperition {
    public void work(StudentsList studentsList) throws IOException, ClassNotFoundException;
}
