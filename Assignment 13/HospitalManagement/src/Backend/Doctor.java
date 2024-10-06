
package Backend;


/**
 *
 * @author Junaid
 */
public class Doctor implements setup{
//    id, name, qualification, designation, salary, datetime
    
    private int id;
    private String name, qualification, designation;
    private double salary;
    private String department;
    
    @Override
    public Object[] getAllData() {
        return new Object[] {id, name, qualification, designation, salary, department} ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Doctor(int id, String name, String qualification, String designation, double salary, String department) {
        this.id = id;
        this.name = name;
        this.qualification = qualification;
        this.designation = designation;
        this.salary = salary;
        this.department = department;
        
    }

    public Doctor(String name, String qualification, String designation, double salary, String department) {
        this.name = name;
        this.qualification = qualification;
        this.designation = designation;
        this.salary = salary;
        this.department = department;
        
    }

    public Doctor() {
    }

    @Override
    public String toString() {
        return "Doctor{" + "id=" + id + ", name=" + name + ", qualification=" + qualification + ", designation=" + designation + ", salary=" + salary + ", department=" + department + '}';
    }
    
    

    
}
