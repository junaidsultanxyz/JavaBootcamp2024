
package Backend;

import java.util.ArrayList;

/**
 *
 * @author Junaid
 */
public class Database {
    private static ArrayList<Patient> patientList = new ArrayList<>();
    private static ArrayList<Doctor> doctorList = new ArrayList<>();
    private static ArrayList<Appointment> appointmentList = new ArrayList<>();
    private static ArrayList<Billing> billingList = new ArrayList<>();
    
    // set all arraylists

    public static void setPatientList(ArrayList<Patient> patientList) {
        Database.patientList = patientList;
    }

    public static void setDoctorList(ArrayList<Doctor> doctorList) {
        Database.doctorList = doctorList;
    }

    public static void setAppointmentList(ArrayList<Appointment> appointmentList) {
        Database.appointmentList = appointmentList;
    }

    public static void setBillingList(ArrayList<Billing> billingList) {
        Database.billingList = billingList;
    }
    
    
    
    // get all the array lists
    public static ArrayList<Patient> getPatientList(){ return patientList; }
    public static ArrayList<Doctor> getDoctorList() { return doctorList; }
    public static ArrayList<Appointment> getAppointmentList() { return appointmentList; }
    public static ArrayList<Billing> getBillingList() { return billingList; }
    
    public static Patient getPatientByID (int id){
        for (Patient p : patientList){
            if (p.getId() == id){
                return p;
            }
        }
        
        return null;
    }
    
    public static Doctor getDoctorByID (int id){
        for (Doctor d : doctorList){
            if (d.getId() == id){
                return d;
            }
        }
        
        return null;
    }
    
    public static Appointment getAppointmentByID (int id){
        for (Appointment a : appointmentList){
            if (a.getId() == id){
                return a;
            }
        }
        
        return null;
    }
    
    public static ArrayList<Patient> getPatientByName(String name){
        ArrayList<Patient> results = new ArrayList<>();
        
        for (Patient p : patientList){
            if (p.getName().equalsIgnoreCase(name)){
                results.add(p);
            }
        }
        
        return results;
    }
    
    public static boolean isAppointmentBilled (int id){
        for (Billing b : billingList){
            if (b.getAppointmentID() == id){
                return true;
            }
        }
        
        return false;
    }
    
    public static ArrayList<Doctor> getDoctorByName(String name){
        ArrayList<Doctor> results = new ArrayList<>();
        
        for (Doctor d: doctorList){
            if (d.getName().equalsIgnoreCase(name)){
                results.add(d);
            }
        }
        
        return results;
    }
    
    public static boolean isPatientAppointed (int id){
        for (Appointment a : appointmentList){
            if (a.getPatientID() == id){
                return true;
            }
        }
        
        return false;
    }
    
    // adding
    public static boolean addPatient (Patient patient){
        boolean check = true;
        for (Patient p : patientList){
            if (p.getId() == patient.getId()){
                check = false;
                break;
            }
        }
        
        if (check){
            patientList.add(patient);
        }
        
        return check;
    }
    
    public static boolean addDoctor (Doctor doctor){
        boolean check = true;
        for (Doctor d : doctorList){
            if (d.getId() == doctor.getId()){
                check = false;
                break;
            }
        }
        
        if (check){
            doctorList.add(doctor);
        }
        
        return check;
    }
    
    public static boolean addAppointment (Appointment appointment){
        boolean check = true;
        for (Appointment a : appointmentList){
            if (a.getPatientID() == appointment.getPatientID() || a.getId() == appointment.getId()){
                check = false;
                break;
            }
        }
        
        if (check){
            appointmentList.add(appointment);
        }
        
        return check;
    }
    
    public static void addBilling (Billing billing){
        billingList.add(billing);
    }
    
    
    // deleting
    public static <T extends setup> boolean deleteEntry (ArrayList<T> list, int id){
        for (T obj : list){
            if (obj.getId() == id){
                list.remove(obj);
                return true;
            }
        }
        
        return false;
    }
    
    public static void deletePatient (int id){
        
    }
    
    public static void deleteDoctor (int id){
        
    }
    
    public static void deleteAppointment (int id){
        
    }
    
    
    // updating
    public static boolean updatePatient (int id, Patient newP){
        for (Patient p : patientList){
            if (id == p.getId()){
                p.setName(newP.getName());
                p.setAge(newP.getAge());
                p.setDisease(newP.getDisease());
                p.setPhone(newP.getPhone());
                
                return true;
            }
        }
        
        return false;
    }
    
    public static boolean updateDoctor (int id, Doctor newD){
        for (Doctor d : doctorList){
            if (id == d.getId()){
                d.setName(newD.getName());
                d.setQualification(newD.getQualification());
                d.setDesignation(newD.getDesignation());
                d.setSalary(newD.getSalary());
                d.setDepartment(newD.getDepartment());
                
                return true;
            }
        }
        
        return false;
    }
    
    
    // searching
    public static <T> ArrayList<T> search (String key, ArrayList<T> list){
        ArrayList<T> results = new ArrayList<>();
        
        for (T p : list){
            if (p.toString().toLowerCase().contains(key.toLowerCase())){
                results.add(p);
            }
        }
        
        return results;
    }
    
    public static void LoadDataFromDatabase(){
        QueryAction query = new QueryAction();
        patientList = query.getPatientsData();
        doctorList = query.getDoctorData();
        appointmentList = query.getAppointmentData();
        billingList = query.getBillingData();
        
    }
    
    public static void SaveDataToDatabase(){
        QueryAction query = new QueryAction();
        query.DeleteAllData();
        
        for (Doctor d : doctorList){
            query.addDoctor(d);
        }
        
        for (Patient p : patientList){
            query.addPatient(p);
        }
        
        
        for (Appointment a : appointmentList){
            query.addAppointment(a);
        }
        
        for (Billing b : billingList){
            query.addBilling(b);
        }
    }
    
    public static void TestData(){
        
    }
}
