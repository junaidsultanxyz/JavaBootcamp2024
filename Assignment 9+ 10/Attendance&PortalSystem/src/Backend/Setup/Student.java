package Backend.Setup;

import Backend.Data.Database;;

public class Student extends Person{
    
    private String studentID;
    private Account account;

    //-------------------------------- S E T T E R S (auto set)


    public void setStudentID(){
        this.studentID = "SID" + Database.getStudentList().size();
    }

    public void setEmail(){
        this.account.setEmail(name.replaceAll(" ", "") + "." + studentID + "@gmail.com");
    }

    //-------------------------------- G E T T E R S


    public String getID(){
        return studentID;
    }


    public Account getAccount(){
        return account;
    }

    //-------------------------------- C O N S T R U C T E R

    public Student(String name, String number, int age, String password) {
        super(name, number, age);
        this.account = new Account(password);
        this.account.setAccountType("STUDENT");
        setStudentID();
        setEmail();
    }
}
