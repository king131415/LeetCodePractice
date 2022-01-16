package javaDailyProctice.Studens_System0113;

import javaDailyProctice.Studens_System0113.DoOperitions.DoOperition;

import java.io.IOException;

public abstract class Users  {
    protected DoOperition[] doOperitions;
    public void menue(){};
    protected void Works(StudentsList studentsList,int chioce) throws IOException, ClassNotFoundException {
        doOperitions[chioce-1].work(studentsList);
    }
}
