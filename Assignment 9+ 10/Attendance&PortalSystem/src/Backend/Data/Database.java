package Backend.Data;

import java.util.ArrayList;

import Backend.Course.Course;
import Backend.Course.Section;
import Backend.Registeration.Request;
import Backend.Setup.Account;
import Backend.Setup.Debug;
import Backend.Setup.Student;
import Backend.Setup.Teacher;


public class Database {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static ArrayList<Teacher> teacherList = new ArrayList<>();
    private static ArrayList<Course>  courseList = new ArrayList<>();
    private static ArrayList<Account> accountList = new ArrayList<>();
    private static ArrayList<Request> requestList = new ArrayList<>();
    
    //--------------------------- L O G I N 

    public static String loginCheck (String email, String password){
        for (Account a : accountList){
            if (a.getEmail().equalsIgnoreCase(email) && a.getPassword().equals(password)){
                return a.getAccountType();
            }
        }

        return "Invalid";
    }


    // -------------------------- S T U D E N T    L I S T

    public static ArrayList<Student> getStudentList() { return studentList; }

    public static void ResetStudent (String id){
        for (Student s : studentList){

            if (s.getID().equalsIgnoreCase(id)){
                s.getAccount().setPassword("student");
                accountList.get(accountList.indexOf(s.getAccount())).setPassword("student");

                Debug.showMessage("Student password reset");
                break;
            }
        }
    }

    public static void RegisterStudent (Student student){
        studentList.add(student);
        accountList.add(student.getAccount());

        Debug.showMessage("Student Account Successfully Registered");
    }

    public static void RemoveStudent (String id){
        for (Student s : studentList){
            if (s.getID().equalsIgnoreCase(id)){
                accountList.remove(s.getAccount());
                studentList.remove(s);

                Debug.showMessage("Account Successfully Removed");
                break;
            }
        }
    }

    public static Student getStudentByID (String id){
        for (Student s : studentList){
            if (s.getID().equalsIgnoreCase(id)){
                return s;
            }
        }

        return null;
    }

    public static Student studentLogin (String email, String password){
        for (Student s : studentList){
            if (s.getAccount().getEmail().equalsIgnoreCase(email) && s.getAccount().getPassword().equals(password)){
                
                return s;
            }
        }

        Debug.showMessage("Student account not found");
        return null;
    }
    

    // -------------------------- T E A C H E R    L I S T

    public static ArrayList<Teacher> getTeacherList() { return teacherList; }

    public static void RegisterTeacher (Teacher teacher, String course){
        
        teacherList.add(teacher);
        accountList.add(teacher.getAccount());
        getCourseByName(course).RegisterTeacher(teacher);
        

        Debug.showMessage("Teacher Account Registered Successfully");
    }

    public static void ResetTeacher (String id){
        for (Teacher t : teacherList){

            if (t.getID().equalsIgnoreCase(id)){
                t.getAccount().setPassword("teacher");
                accountList.get(accountList.indexOf(t.getAccount())).setPassword("teacher");

                Debug.showMessage("Teacher account reset");
                break;
            }
        }
    }

    public static void DeleteTeacher (String id){
        for (Teacher t : teacherList){
            if (t.getID().equalsIgnoreCase(id)){
                accountList.remove(t.getAccount());
                teacherList.remove(t);

                Debug.showMessage("Account Successfully Removed");
                break;
            }
        }
    }

    public static Teacher getTeacherByID (String id){
        for (Teacher t : teacherList){
            if (t.getID().equalsIgnoreCase(id)){
                return t;
            }
        }

        return null;
    }


    public static Teacher loginTeacher (String email, String password){
        for (Teacher t : teacherList){
            if (t.getAccount().getEmail().equalsIgnoreCase(email) && t.getAccount().getPassword().equals(password)){
                return t;
            }
        }

        Debug.showMessage("Teacher account not found");
        return null;
    }

    // -------------------------- C O U R S E S    L I S T
    
    public static void addCourse (Course course){
        boolean check = true;
        for (Course c : courseList){
            if (c.getName().equalsIgnoreCase(course.getName())){
                check = false;
                Debug.showMessage("course already exist");
                break;
            }
        }
        
        if (check){
            courseList.add(course);
        }
    }
    
    public static void removeCourse (String name){
        boolean check = false;
        
        for (Course c : courseList){
            if (c.getName().equalsIgnoreCase(name)){
                check = true;
                courseList.remove(c);
                
                Debug.showMessage("course removed");
                break;
            }
        }
        
        if (!check){
            Debug.showMessage("course does not exist");
        }
    }
    
    public static ArrayList<Course> getCourseList(){
        return courseList;
    }

    public static ArrayList<Course> getAvailableCourses (Student student){
        ArrayList<Course> coursesAvailable = new ArrayList<>();

        for (Course c : courseList){
            boolean check = true;
            
            for (Section s : c.getSectionList()){
                if (s.getStudentList().contains(student)){
                    check = false;
                }
            }
            
            if (check){
                coursesAvailable.add(c);
            }
        }

        return coursesAvailable;
    }

    public static Course getCourseByName(String name){

        for (Course c : courseList){
            if (c.getName().equalsIgnoreCase(name)){

                return c;
            }
        }

        Debug.showMessage(name + " section not found");
        return null;
    }

    // only enrolled courses and sections
    public static ArrayList<Course> getEnrolledCourses (Student student){
        
        ArrayList<Course> tempCourse = new ArrayList<>();
        
        for (Course c : courseList){
            ArrayList<Section> tempSection = new ArrayList<>();
            
            for (Section s : c.getSectionList()){
                if (s.checkStudentByID(student.getID())){
                    tempSection.add(s);
                    break;
                }
            }
            
            if (!tempSection.isEmpty()){
                tempCourse.add(new Course(c.getName(), tempSection));
            }
        }

        return tempCourse;

    }

    //  for teachers
    public static ArrayList<Course> getEnrolledCourses (String teacherId){
        ArrayList<Course> tempCourse = new ArrayList<>();

        
        for (Course c : courseList){
            ArrayList<Section> tempSection = new ArrayList<>();
            
            for (Section s : c.getSectionList()){
                String tID = "";

                try
                { tID = s.getTeacher().getID(); }
                catch (Exception e){}
                
                if (tID.equals(teacherId)){
                    tempSection.add(s);
                }
            }
            
            if (!tempSection.isEmpty()){
                tempCourse.add(new Course(c.getName(), tempSection));
            }
        }

        return tempCourse;
    }

    // -------------------------- E N R O L L M E N T

    public static ArrayList<Request> getAllEnrollmentList (){
        return requestList;
    }

    // enroll list for admin
    public static ArrayList<Request> getPendingEnrollments (){
        ArrayList<Request> enrollments = new ArrayList<>();

        for (Request r : requestList){
            if (r.getStatus() == false){
                enrollments.add(r);
            }
        }

        return enrollments;
    }


    // enroll list for student
    public static ArrayList<Request> getPendingEnrollments (String studentID){
        ArrayList<Request> enrollments = new ArrayList<>();

        for (Request r : requestList){
            if (r.getStudent().getID().equalsIgnoreCase(studentID)){
                enrollments.add(r);
            }
        }

        return enrollments;
    }

    public static void AddRequest (Request request){
        requestList.add(request);
        Debug.showMessage("Enrollment request sent");
    }

    public static void AcceptEnrollment (Request request){
        boolean check = false;

        for (Request r : requestList){
            if (request.getStudent().getID().equalsIgnoreCase(r.getStudent().getID()) &&
                request.getCourse().getName().equalsIgnoreCase(r.getCourse().getName()) &&
                request.getSection().getName().equalsIgnoreCase(r.getSection().getName()))
            {
                check = true;
                getCourseByName(request.getCourse().getName()).getSectionByName(r.getSection().getName()).addStudent(r.getStudent());
                
                r.setStatus(true);
                Debug.showMessage("Student Enrolled !");

                break;
            }
        }

        if (!check){
            Debug.showMessage("Invalid Enrollment request");
        }
    }

    public static void RejectEnrollment (Request request){
        boolean check = false;

        for (Request r : requestList){
            if (request.getStudent().getID().equalsIgnoreCase(r.getStudent().getID()) &&
                request.getCourse().getName().equalsIgnoreCase(r.getCourse().getName()) &&
                request.getSection().getName().equalsIgnoreCase(r.getSection().getName()))
            {
                check = true;
                requestList.remove(r);
                
                r.setStatus(true);
                Debug.showMessage("request rejected");

                break;
            }
        }

        if (!check){
            Debug.showMessage("Invalid Enrollment request");
        }
    }

    // -------------------------- A C C O U N T    L I S T

    public static ArrayList<Account> getAccountList() { return accountList; }

    
    // -------------------------- TEST DATA
    
    public static void TestData(){
        accountList.add(new Account("admin@gmail.com", "admin", "admin"));
        
        
        
        
        
        courseList.add(new Course("Calculus-1"));
        courseList.add(new Course("Linear Algebra"));
        courseList.add(new Course("Probability & Statistics"));
        
        for (Course c : courseList){
            c.addSection(new Section("W-1"));
            c.addSection(new Section("W-2"));
            c.addSection(new Section("W-3"));
            c.addSection(new Section("W-4"));
            c.addSection(new Section("W-5"));
            
        }
    }
}
