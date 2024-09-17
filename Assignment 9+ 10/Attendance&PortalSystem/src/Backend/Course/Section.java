package Backend.Course;

import java.util.ArrayList;

import Backend.Attendace.Attendance;
import Backend.Setup.Debug;
import Backend.Setup.Student;
import Backend.Setup.Teacher;

public class Section {
    private int studentLimit = 50;
    private String name;
    private Teacher teacher;
    private ArrayList<Student> students;
    private ArrayList<Attendance> attendanceList;


    public void setName(String name){
        if (!name.isBlank()){ this.name = name; }
    }
    public String getName (){ return name; }


    public void setTeacher(Teacher teacher){
        if (teacher != null){
            this.teacher = teacher;
        }
        else { Debug.showMessage("There already exists a teacher for this section");}
    }
    public Teacher getTeacher(){ return teacher; }


    public void setStudentList(ArrayList<Student> studentList){
        this.students = studentList;
    }

    public ArrayList<Student> getStudentList(){ return students; }
    
    public boolean checkStudentByID (String id){
        for (Student s : students){
            if (s.getID().equalsIgnoreCase(id)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Attendance> getAttendanceList(){ return attendanceList; }
    
    public Attendance getAttendanceByDate (String date) {
        for (Attendance a : attendanceList){
            if (a.getDate().equalsIgnoreCase(date)){
                return a;
            }
        }

        return null;
    }
    
    public void addStudent(Student student){
        if (students.size() < studentLimit){
            students.add(student);
        }
        else{
            Debug.showMessage("students limit is reached in this section");
        }
    }

    public void removeStudent (String id){
        boolean check = false;

        for (Student s : students){
            if (s.getID().equalsIgnoreCase(id)){
                students.remove(s);
                check = true;

                Debug.showMessage("Student removed !");
                break;
            }
        }

        if (!check){
            Debug.showMessage("Student not found");
        }
    }

    public void removeTeacher (String id){
        if (teacher.getID().equalsIgnoreCase(id)){
            teacher = null;

            Debug.showMessage("Teacher removed from section " + this.getName());
        }
    }


    public void saveAttendance(Attendance attendance){
        attendanceList.add(attendance);
    }


    public Section () {}

    public Section (String name){
        setName(name);
        students = new ArrayList<>();
        attendanceList = new ArrayList<>();
    }
    
    public Section (String name, Teacher teacher){
        setName(name);
        students = new ArrayList<>();
        attendanceList = new ArrayList<>();
        setTeacher(teacher);
    }
    
    public Section (String name, Teacher teacher, ArrayList<Student> liststudent){
        setName(name);
        students = liststudent;
        attendanceList = new ArrayList<>();
        setTeacher(teacher);
    }
}
