
package Backend;

/**
 *
 * @author Junaid
 */
public class Patient implements setup{
    private int id;
    private String name;
    private int age;
    private String disease;
    private String phone;

    @Override
    public Object[] getAllData() {
        return new Object[] {id, name, age, disease, phone} ;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Patient(int id, String name, int age, String disease, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.phone = phone;
    }

    public Patient(String name, int age, String disease, String phone) {
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.phone = phone;
    }
    
    public Patient (){}

    @Override
    public String toString() {
        return "Patient{" + "id=" + id + ", name=" + name + ", age=" + age + ", disease=" + disease + ", phone=" + phone + '}';
    }
}
