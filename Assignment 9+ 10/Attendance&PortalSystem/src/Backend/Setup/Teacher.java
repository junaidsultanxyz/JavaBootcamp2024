package Backend.Setup;

import Backend.Data.Database;

public class Teacher extends Person {

    private String teacherID;
    private Account account;

    //-------------------------------- S E T T E R S

    public void setEmail (){
        this.account.setEmail(name.replaceAll(" ", "") + "." + teacherID + "@gmail.com");
    }


    public void setTeacherID (){
        this.teacherID = "IDT" + Database.getTeacherList().size();
    }


    //-------------------------------- G E T T E R S


    public String getID(){
        return teacherID;
    }

    public Account getAccount(){
        return account;
    }

    //-------------------------------- C O N S T R U C T E R


    public Teacher(String name, String number, int age, String password) {
        super(name, number, age);
        this.account = new Account(password);
        this.account.setAccountType("Teacher");
        setTeacherID();
        setEmail();
    }
}
