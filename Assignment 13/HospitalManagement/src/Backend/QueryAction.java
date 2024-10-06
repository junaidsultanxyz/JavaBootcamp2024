package Backend;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class QueryAction {
    String url, username, password;


    public String deleteAllQuery (String table){
        return "DELETE FROM " + table;
    }
    
    
    public void addPatient(Patient patient){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected !");
            String query = "INSERT INTO patient(id, name, age, disease, phone) VALUES (?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            
            
            statement.setInt(1, patient.getId());
            statement.setString(2, patient.getName());
            statement.setInt(3, patient.getAge());
            statement.setString(4, patient.getDisease());
            statement.setString(5, patient.getPhone());

            int result = statement.executeUpdate();

            if (result > 0) { System.out.println("data inserted"); }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addDoctor(Doctor doctor){
        String query = "INSERT INTO doctor(id, name, qualification, designation, salary, department) VALUES (?,?,?,?,?,?)";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected !");
            
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, doctor.getId());
            statement.setString(2, doctor.getName());
            statement.setString(3, doctor.getQualification());
            statement.setString(4, doctor.getDesignation());
            statement.setDouble(5, doctor.getSalary());
            statement.setString(6, doctor.getDepartment());
            
            int result = statement.executeUpdate();

            if (result > 0) { System.out.println("data inserted"); }

            statement.close();
            connection.close();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addAppointment(Appointment appointment){
        String query = "INSERT INTO appointments(id, type, patient_id, doctor_id) VALUES (?,?,?,?)";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected !");
            PreparedStatement statement = connection.prepareStatement(query);
            
            connection.prepareStatement(query);
            statement.setInt(1, appointment.getId());
            statement.setString(2, appointment.getType());
            statement.setInt(3, appointment.getDoctorID());
            statement.setInt(4, appointment.getPatientID());
            
            int result = statement.executeUpdate();

            if (result > 0) { System.out.println("data inserted"); }

            statement.close();
            connection.close();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addBilling(Billing billing){
        String query = "INSERT INTO bill(amount, appointment_id, payer_name) VALUES (?,?,?)";
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected !");
            PreparedStatement statement = connection.prepareStatement(query);
            
            connection.prepareStatement(query);
            statement.setDouble(1, billing.getAmount());
            statement.setInt(2, billing.getAppointmentID());
            statement.setString(3, billing.getPayer());
            
            int result = statement.executeUpdate();

            if (result > 0) { System.out.println("data inserted"); }

            statement.close();
            connection.close();
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public ArrayList<Patient> getPatientsData (){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected !");

            Statement  statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM patient");

            ArrayList<Patient> data = new ArrayList<>();
            
            while (result.next()) {
                int id = result.getInt(1);
                String name = result.getString(2);
                int age = result.getInt(3);
                String disease = result.getString(4);
                String phone = result.getString(5);
                
                data.add(new Patient(id, name, age, disease, phone));
            }
            

            result.close();
            statement.close();
            connection.close();
            
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Doctor> getDoctorData (){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected !");

            Statement  statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM doctor");

            ArrayList<Doctor> data = new ArrayList<>();
            
            while (result.next()) {
                int id = result.getInt(1);
                String name = result.getString(2);
                String qualification = result.getString(3);
                String designation = result.getString(4);
                double salary = result.getDouble(5);
                String department = result.getString(6);
                
                data.add(new Doctor(id, name, qualification, designation, salary, department));
            }
            

            result.close();
            statement.close();
            connection.close();
            
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Appointment> getAppointmentData (){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected !");

            Statement  statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM appointments");

            ArrayList<Appointment> data = new ArrayList<>();
            
            while (result.next()) {
                int id = result.getInt(1);
                String type = result.getString(2);
                int pat_id = result.getInt(3);
                int doc_id = result.getInt(4);
                LocalDateTime time = result.getTimestamp(5).toLocalDateTime();

                
                data.add(new Appointment(id, type, pat_id, doc_id, time));
            }
            

            result.close();
            statement.close();
            connection.close();
            
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public ArrayList<Billing> getBillingData (){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected !");

            Statement  statement = connection.createStatement();

            ResultSet result = statement.executeQuery("SELECT * FROM bill");

            ArrayList<Billing> data = new ArrayList<>();
            
            while (result.next()) {
                double amount = result.getDouble(1);
                int app_id = result.getInt(2);
                String payer = result.getString(3);
                LocalDateTime time = result.getTimestamp(4).toLocalDateTime();

                
                data.add(new Billing(amount, app_id, payer, time));
            }
            

            result.close();
            statement.close();
            connection.close();
            
            return data;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void DeleteAllData(){
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            
            String[] table_names = {"patient", "doctor", "appointments", "bill"};

            for (String table_name : table_names) {
                PreparedStatement statement = connection.prepareStatement(deleteAllQuery(table_name));
                statement.execute();
                statement.close();
            }
            
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public QueryAction(){
        this.url = "jdbc:mysql://localhost:3306/junaid_hospital";
        this.username = "test";
        this.password = "j_sultan115";
    }
}
