public class Manager {

    public static final String position = "Manager";
    private String name;
    private int salary;
    private String department;

    public void setName(String name){
        this.name = name;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public String getName(){
        return name;
    }

    public int getSalary(){
        return salary;
    }

    public String getDepartment(){
        return department;
    }

}
