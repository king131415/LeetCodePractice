package javaSePrictice;
import java.util.ArrayList;
import java.util.List;
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
    public  static int getImportance(List<Employee> employees, int id) {
        for (Employee e: employees) {
            if (e.id == id) {
                if (e.subordinates.size() == 0) {  // 没有子结点
                    return e.importance;
                }
                for (int subId: e.subordinates) {
                    e.importance += getImportance(employees, subId); //递归直到没有下属为止
                }
                return e.importance;
            }
        }
        return 0;

    }
}
public class 员工重要性问题 {
    /**
     * [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
     * 输出: 11
     *
     * [[1,2,[2]], [2,3,[]]]
     * 2
     */
    public static void main(String[] args) {
        List<Employee> employee1=new ArrayList<>();
        List<Integer> sub=new ArrayList<>();
        Employee employee=new Employee();
        employee.id=1;
        employee.importance=5;
        sub.add(2);
        sub.add(3);
        employee.subordinates=sub;
        employee1.add(employee);
        Employee employee2=new Employee();
        employee2.id=2;
        employee2.importance=3;
        List<Integer> sub2=new ArrayList<>();
        employee2.subordinates=sub2;
        employee1.add(employee2);
        Employee employee3=new Employee();
        employee3.id=3;
        employee3.importance=3;
        List<Integer> sub3=new ArrayList<>();
        employee3.subordinates=sub3;
        employee1.add(employee3);
        int result= Employee.getImportance(employee1,1);
        System.out.println(result);

    }
}
