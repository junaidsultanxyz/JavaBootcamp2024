package Backend.Attendace;   

import java.util.ArrayList;

import Backend.Setup.Student;


public class Attendance {
    private ArrayList<Student> presentStudent = new ArrayList<>();
    private String date;


    public String getDate(){
        return date;
    }

    public ArrayList<Student> getPresentStudents(){
        return presentStudent;
    }
    
    public boolean isPresent (Student student){
        for (Student s : presentStudent){
            if (s.getID().equalsIgnoreCase(student.getID())){
                return true;
            }
        }
        
        return false;
    }
    
    public void markPresent(Student student){
        presentStudent.add(student);
    }
    
    public void markAbsent(String id){
        for (Student s : presentStudent){
            if (s.getID().equalsIgnoreCase(id)){
                presentStudent.remove(s);
                break;
            }
        }
    }

    
    public Attendance(){

        this.date = "" + java.time.LocalDate.now();

    }
}
