package Backend.Setup;

public class Person {
    protected String name;
    protected String number;
    protected int age;

    protected final int minAge = 15;

    //-------------------------------- S E T T E R S
    
    public void setName(String name){
        if (!name.isBlank()){
            this.name = name;
        }
    }
    
    public void setNumber(String number){
        if (!number.isBlank()){
            this.number = number;
        }
    }

    public void setAge(int age){
        if (age > minAge){
            this.age = age;
        }
    }

    //-------------------------------- G E T T E R S
    
    public String getName(){
        return name;
    }
    
    public String getNumber(){
        return number;
    }
    
    public int getAge(){
        return age;
    }
    
    
    //-------------------------------- C O N S T R U C T E R

    public Person(String name, String number, int age){
        setName(name);
        setAge(age);
        setNumber(number);
    }
}
