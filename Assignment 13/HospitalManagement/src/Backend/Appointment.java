
package Backend;

import java.time.LocalDateTime;

/**
 *
 * @author Junaid
 */
public class Appointment implements setup{
    private int id;
    private String type;
    private int patientID;
    private int doctorID;
    private LocalDateTime datetime;
    
    @Override
    public Object[] getAllData() {
        return new Object[] {id, type, doctorID, patientID, datetime} ;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public Appointment(int id, String type, int patientID, int doctorID, LocalDateTime datetime) {
        this.id = id;
        this.type = type;
        this.patientID = patientID;
        this.doctorID = doctorID;
        this.datetime = datetime;
    }

    public Appointment(String type, int patientID, int doctorID) {
        this.type = type;
        this.patientID = patientID;
        this.doctorID = doctorID;
    }

    public Appointment() {
    }

    @Override
    public String toString() {
        return "Appointment{" + "id=" + id + ", type=" + type + ", patient=" + patientID + ", doctor=" + doctorID + ", datetime=" + datetime + '}';
    }
    
    
}
