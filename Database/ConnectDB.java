package Database;

/**
 * This class serves as the connection to the Database to store users.
 *
 * @author Amantii last updated: 11/29/20
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    Connection connect;
    PreparedStatement ps;

    static final String host = "jdbc:mysql://localhost:3306/hospital_DB?zeroDateTimeBehavior=convertToNull";
    static final String user = "root";
    static final String password = "";

    public ConnectDB() {
        this.connection();
    }

    /**
     * Creates the connection to the database to insert users.
     *
     * @param _firstname
     * @param _lastname
     * @param _email
     * @param _password
     * @throws SQLException
     */
    public void accountInsertion(String _firstname, String _lastname, String _email, String _password) throws SQLException {
        String insert = "INSERT INTO cancer_patient(firstname,lastname,email,password) VALUES(?,?,?,?)";
        ps = (PreparedStatement) connect.prepareStatement(insert);
        ps.setString(1, _firstname);
        ps.setString(2, _lastname);
        ps.setString(3, _email);
        ps.setString(4, _password);

        System.out.println(ps);

        ps.executeUpdate();
    }

    public void patientDetailsInsertion(String _firstname, String _lastname, String _gender, String _dob) throws SQLException {
        String detailsInsert = "INSERT INTO patient_details(firstname,lastname,gender,dob) VALUES(?,?,?,?)";
        ps = (PreparedStatement) connect.prepareStatement(detailsInsert);
        ps.setString(1, _firstname);
        ps.setString(2, _lastname);
        ps.setString(3, _gender);
        ps.setString(4, _dob);

        System.out.println(ps);
        ps.executeUpdate();
    }

    public void apptInsertion(String _start, String _end, String _title, String _apptId) throws SQLException {
        String apptInsert = "INSERT INTO create_appt(Appointment_id,start,end,title) VALUES(?,?,?,?)";
        ps = (PreparedStatement) connect.prepareStatement(apptInsert);
        ps.setString(1, _apptId);
        ps.setString(2, _start);
        ps.setString(3, _end);
        ps.setString(4, _title);

        System.out.println(ps);
        ps.executeUpdate();
    }

    public void deleteAppt(String _id) throws SQLException {
        String deleteInsert = "DELETE FROM `create_appt` WHERE Appointment_id = Appointment_id";

        ps = (PreparedStatement) connect.prepareStatement(deleteInsert);

        System.out.println(ps);
        ps.executeUpdate();
    }

    public PreparedStatement GetAllAppt() throws SQLException {
        String showAppt = "SELECT * from create_appt where patient_id = patient_id";

        ps = (PreparedStatement) connect.prepareStatement(showAppt);

        System.out.println(ps);
        ps.executeQuery();
        return ps;
    }

    /**
     * Helper method to establish connection to database.
     */
    private void connection() {
        try {
            connect = DriverManager.getConnection(host, user, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
