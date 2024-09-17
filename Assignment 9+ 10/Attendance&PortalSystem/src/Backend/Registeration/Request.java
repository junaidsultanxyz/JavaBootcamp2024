package Backend.Registeration;

import Backend.Course.Course;
import Backend.Course.Section;
import Backend.Setup.Student;

public class Request {
    private Student student;
    private Course course;
    private Section section;
    private boolean status;

    public void setStatus(boolean status) { this.status = status; }
    // true -> active req   |   false -> req disclosed


    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public Section getSection() { return section; }
    public boolean getStatus() { return status; }

    public Request(Student student, Course course, Section section){
        this.status = false;
        this.student = student;
        this.course = course;
        this.section = section;
    }
}
