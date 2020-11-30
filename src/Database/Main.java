import java.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import mainPackage.Patient;
import mainPackage.Doctor;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static final int MENU_EXIT = 0;
    public static final int CREATE_APPOINTMENT = 1;
    public static final int DISPLAY_CALENDAR = 2;

    public static void main(String[] args) throws SQLException {

        Main m = new Main();
        int choice = -1;
        while (choice != MENU_EXIT) {
            choice = m.displayMenu();
            m.handleChoice(choice);
        }

    }

    public int displayMenu() {
        int r = -1;
        System.out.println("Select from the choices below: ");
        System.out.println("0.exit");
        System.out.println("1. Create Appointment");
        System.out.println("2. Display Calendar");
        Scanner scan = new Scanner(System.in);
        r = scan.nextInt();
        scan.nextLine();
        return r;
    }

    public void handleChoice(int choice) {
        switch (choice) {
            case CREATE_APPOINTMENT:
                createAppointment();
                break;
            case DISPLAY_CALENDAR:
                displayCalendar();
                break;
        }

    }

    public void createAppointment() {
        System.out.println("Creating appointment");
        System.out.print("What's your id number?: ");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Patient p = lookupPatientById(input);
        if(p!= null)
        System.out.println("Patient " + p.getName() + " found");
        System.out.print("What's the doctor's name?: ");
        input = scanner.nextLine();;
        Doctor d = lookupDoctorById(input);
        System.out.println(p.getName());
        System.out.println(d.getName());
        System.out.println("What date do you prefer?: ");
        input = scanner.nextLine();
        String dateOfappointment = input;
        ArrayList<String> freeSlots = getFreeSlots(Integer.parseInt(d.getDoc_id()), input);
        System.out.println("Select the slot from the list below: ");
        int i=1;
        for(String slot: freeSlots){
            System.out.print(i + ". ");
            System.out.println(slot);
            i++;
        };
        input = scanner.nextLine();
        createAppointment(freeSlots.get(Integer.parseInt(input)), d,p, dateOfappointment);





    }

    public void createAppointment(String slot, Doctor d, Patient p, String dateOfappointment){
        slot = slot.replaceAll("\\*", "");
        String start_date = dateOfappointment + " " + slot.split("-") [0];
        String end_date = dateOfappointment+ " " +slot.split("-") [1];
        String appointmentId = String.valueOf(((Math.random() * (999999 - 1)) + 1));
        String notes = "new appointment for " + p.getName() + " with " + d.getName();
        String sql = " INSERT INTO `appointment` (`appointment_id`,`start_date`,`end_date`,`notes`,`doc_id`,`pat_id`,`pat_username`,`doc_username`)VALUES('"+appointmentId+"','"+start_date+"','"+end_date+"','"+notes+"','"+d.getDoc_id()+"','"+p.getPat_id()+"','"+p.getName()+"','"+d.getName()+"')";
        System.out.println(sql);
                executeQuery(sql, new ArrayList<String>());
    }

    public void displayCalendar() {
        System.out.println("Displaying Calendar");
    }

    public Patient lookupPatientById(String id) {
        String sql = "Select * from patient where pat_id = " + id;
        ArrayList<String> colNames = new ArrayList<String>();
        colNames.add("first_name");
        colNames.add("pat_id");
        List <HashMap<String, String>> results = (List <HashMap<String, String>>) executeQuery(sql, colNames);
        Patient patient = new Patient();
       patient.setPat_id (((HashMap<String,String>)results.get(0)).get("pat_id"));
       patient.setName (((HashMap<String,String>)results.get(0)).get("first_name"));
       return patient;


    }
// 8876779
//    49491
    public Doctor lookupDoctorById(String id) {
        String sql = "Select * from doctor where doc_id = " + id;
        ArrayList<String> colNames = new ArrayList<String>();
        colNames.add("first_name");
        colNames.add("doc_id");
        List <HashMap<String, String>> results = executeQuery(sql, colNames);
        Doctor doctor = new Doctor();
        doctor.setDoc_id (((HashMap<String,String>)results.get(0)).get("doc_id"));
        doctor.setName (((HashMap<String,String>)results.get(0)).get("first_name"));
        return doctor;
    }
//    getFreeSlotsByDocAndDate(doctorDetails.id, dateOfAppointment)
//    availableSlots = ""
//    run select query to get all slots for dateOfAppointment and doc_id
//    construct string to represent slotsTaken from results
//	for eg: slotsTaken = "*10.00-11.00*,*12.00-13.00*,*13.00-14.00*,*14.00-15.00*"
//    allSlots="*9.00-10.00*,*10.00-11.00*,*11.00-12.00*,*12.00-13.00*,*13.00-14.00*,*14.00-15.00*..."
//    slotsTakenArray = slotsTaken.split(',')
//    loop thru list
//		if allSlots.contains(slotsTakenArray[i])
//            continue
//            else
//    availableSlots += slotsTakenArray[i] + ","
//            return availableSlots
    public ArrayList<String> getFreeSlots(int doctorId, String dateOfappointment){
        String sql = "select substr( time(start_date),1, 5) start_date, substr(time(end_date),1, 5)  end_date from appointment where doc_id  = " + doctorId + " and date(start_date)= '" + dateOfappointment  + "'";
        System.out.println(sql);
        ArrayList<String> freeSlots = new ArrayList<String>();
        ArrayList<String> usedSlots = new ArrayList<String>();
        ArrayList<String> colNames = new ArrayList<String>();
        colNames.add("start_date");
        colNames.add("end_date");
        List <HashMap<String, String>> results = executeQuery(sql, colNames);
        results.forEach(record -> {
            HashMap<String, String> h = record;

            usedSlots.add("*" + h.get("start_date")+ "-" + h.get("end_date") + "*");
        });
        String allSlots="*9:00-10:00*,*10:00-11:00*,*11:00-12:00*,*12:00-13:00*,*13:00-14:00*,*14:00-15:00*,*15:00-16:00*,*16:00-17:00*,*17:00-18:00*";
        String allSlotsArray[] = allSlots.split(",");
        for(int i = 0; i<allSlotsArray.length; i++){
            String slot = allSlotsArray[i];
            if (usedSlots.contains(slot)) {
                continue;
            }
            else{
                freeSlots.add(slot);
            }
        }
        return freeSlots;


    }

    public List <HashMap<String, String>> executeQuery(String sql, ArrayList<String> colNames) {
        String myDriverClass = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/hospital_DB";
        String user = "root";
        String password = "root";

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet rs = null;
        List<HashMap<String, String>> results = new ArrayList<HashMap<String, String>>();

        try {
            System.out.println("Getting connection");
            myConn = DriverManager.getConnection(url, user, password);
            System.out.println("Creating Statement");
            myStmt = myConn.createStatement();
            System.out.println("Executing query");
            if (sql.toLowerCase().trim().startsWith("insert")){
                myStmt.executeUpdate(sql);
                return results;
            }
            rs = myStmt.executeQuery(sql);
            System.out.println("Query executed");


            while (rs.next()) {
                HashMap<String,String> h = new HashMap<String, String>();
                for(String col: colNames){
                    h.put(col,rs.getString(col));
                }
                results.add(h);
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to DB: " + e.getMessage());
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (rs != null) {
                try {

                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Error connecting to DB: " + e.getMessage());
                }
            }

            if (myStmt != null) {
                try {

                    myStmt.close();
                } catch (SQLException e) {
                    System.out.println("Error connecting to DB: " + e.getMessage());
                }
            }

            if (myConn != null) {
                try {

                    myConn.close();
                } catch (SQLException e) {
                    System.out.println("Error connecting to DB: " + e.getMessage());
                }
            }

            return results;
        }


    }
}



//    displayAndChooseAvailableSlots(availableSlots)
//    in a loop
//        availableSlotsArray = availableSlots.split(',')
//    print info about each slot with a number
//	for i = 1 to availableSlotsArray.length
//            print i + "." + availableSlotsArray[i]
//            for eg:
//            1. 9.00-10.00
//            2. 11.00-12.00
//            3. 15.00-16.00 ....
//            return selectedSlotNo
//
//            selectSlot(availableSlots, slotNo, doc_id, patient_id)
//            string slot = availableSlots.split(',')[slotNo]
//            Create Appointment with slot start, end and other parameters
//            return Appointment
//
//            fixAppointment(Appointment)
//            run insert query using properties of Appointment object
//
//
//
//            menu:
//            createappointment
//            what's your number/identifier?
//            a123
//            lookup patient details
//            display patient details
//            which doctor do you want an appointment with?
//            john
//            when do you want to meet the doctor?
//            01/12/2020
//            find the doctors id by the name
//            lookup the appointments table for that doctor id
//            display a list of available slots
//            1,2,3,4,5,6
//            3 ->
//            confirm
//            insert a record in the appointments table
//            doc_id, time_start, time_end, patient_id


// establish DB url
//        String myDriverClass = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://localhost:3306/hospital_DB";
//        String user = "root";
//        String password = "password";
//
//        Connection myConn = null;
//        Statement myStmt = null;
//        ResultSet rs = null;
//
//        try {
//            myConn = DriverManager.getConnection(url, user, password);
//            myStmt = myConn.createStatement();
//            String sql = "Select * from hospital_DB.appointment";
//            rs = myStmt.executeQuery(sql);
////            INSERT INTO `appointments` (`id`,`user_id`,`title`,`date`, `start`,`end`,`note`)
////            VALUES('28222', 'chri8472f', 'Radiation','2020-12-27', '12:45:00', '11:15:00', 'gghs adj hhdj');
//
//            while (rs.next()) {
//                System.out.println(rs.getString("doc_id") + "\t\t " + rs.getString("pat_id") + "\t\t " + rs.getString("appointment_id") + "\t\t "+ rs.getDate("date") + "\t\t" + rs.getTime("time") + "\t\t" + rs.getString("notes"));
//            }
//
//        } catch (SQLException e) {
//            System.out.println("Error connecting to DB: " + e.getMessage());
//        }
//        catch (Exception exc) {
//            exc.printStackTrace();
//        }
//        finally {
//            if (rs != null) {
//                rs.close();
//            }
//
//            if (myStmt != null) {
//                myStmt.close();
//            }
//
//            if (myConn != null) {
//                myConn.close();