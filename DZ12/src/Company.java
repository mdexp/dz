import java.util.ArrayList;

public class Company {

    private ArrayList<Manager> managers = new ArrayList<Manager>();
    private ArrayList<Engineer> engineers = new ArrayList<Engineer>();

    public void addManager(String name, int salary,String department){
        Manager manager = new Manager();
        manager.setName(name);
        manager.setSalary(salary);
        manager.setDepartment(department);
        managers.add(manager);
    }

    public void addEngineer(String name, int salary,String department){
        Engineer engineer = new Engineer();
        engineer.setName(name);
        engineer.setSalary(salary);
        engineer.setDepartment(department);
        engineers.add(engineer);
    }

    public void removeManager(String name){
        for (Manager manager : managers){
            if (manager.getName().equals(name)) {
                managers.remove(manager);
                break;
            }
        }
    }

    public void removeEngineer(String name){
        for (Engineer engineer : engineers){
            if (engineer.getName().equals(name)) {
                engineers.remove(engineer);
                break;
            }
        }
    }

    public int getEmployeesCount(){
        return (managers.size() + engineers.size());
    }

    public int getCommomSalary(){
        int commomSalary = 0;

        for (Manager manager : managers){
            commomSalary += manager.getSalary();
        }
        for (Engineer engineer : engineers){
            commomSalary += engineer.getSalary();
        }

        return commomSalary;
    }

    public int getAvgSalary() {
        return (getCommomSalary()/getEmployeesCount());
    }

}