package Backend.Course;

import java.util.ArrayList;

import Backend.Setup.Debug;
import Backend.Setup.Teacher;


public class Course {
    
    private String name;
    private ArrayList<Section> sections;

    //-------------------------------- S E T T E R S

    public void setName(String name){
        if (!name.isBlank()){
            this.name = name;
        }
    }
    
    public String getName(){ return name; }
    public ArrayList<Section> getSectionList(){ return sections; }


    public void addSection (Section section){
        if (section != null){
            sections.add(section);
        }
    }

    public void removeSection (String sectionName){
        boolean check = false;

        for (Section s : sections){
            if (s.getName().equalsIgnoreCase(sectionName)){
                sections.remove(s);
                check = true;

                Debug.showMessage(sectionName + " Section Removed from " + this.getName());
                break;
            }
        }

        if (!check){
            Debug.showMessage(sectionName + " Section not found in " + this.getName());
        }
    }
    

    public Section getSectionByName(String name){
        for (Section s : sections){
            if (s.getName().equalsIgnoreCase(name)){
                return s;
            }
        }
        return null;
    }


    public boolean RegisterTeacher (Teacher t){
        boolean check = false;

        for (Section s : sections){
            if (s.getTeacher() == null){
                s.setTeacher(t);
                check = true;

                Debug.showMessage(t.getName() + " is now teacher of " + this.getName() + " - " + s.getName());
                break;
            }
        }

        if (!check){
            Debug.showMessage("All the sections for " + this.getName() + " are filled");
        }

        return check;
    }
    
    public Section getTeachersSection (Teacher teacher){
        
        for (Section s : sections){
            if (s.getTeacher().getID().equalsIgnoreCase(teacher.getID())){
                return s;
            }
        }
        
        return null;
    }
    
    public ArrayList<Section> getTeachersSections (String teacherId){
        ArrayList<Section> e_sections = new ArrayList<>();
        
        for (Section s : sections){
            if (s.getTeacher().getID().equalsIgnoreCase(teacherId)){
                e_sections.add(s);
            }
        }
        
        return e_sections;
    }
    //-------------------------------- C O N S T R U C T O R


    public Course(){
        sections = new ArrayList<>();
    }

    public Course(String name){
        setName(name);
        sections = new ArrayList<>();
    }

    public Course (String name, ArrayList<Section> sections){
        setName(name);
        this.sections = sections;
    }

    public Course (Course c){
        setName(c.getName());
        this.sections = c.getSectionList();
    }
}
