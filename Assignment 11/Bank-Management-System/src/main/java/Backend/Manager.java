
package Backend;

/**
 *
 * @author Junaid Sultan
 */
public class Manager {
    private String name, number, cnic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public Manager(String name, String number, String cnic) {
        this.name = name;
        this.number = number;
        this.cnic = cnic;
    }
}
