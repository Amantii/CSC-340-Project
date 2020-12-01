package Database;

/**
 * This class serves as the connection to the Database to store users.
 *
 * @author Amantii last updated: 11/29/20
 */
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    Connection connect;
    PreparedStatement ps;

    static final String host = "jdbc:mysql://localhost:3306/hospital_DB";
    static final String user = "root";
    static final String password = "password";
    static final String insert = "INSERT INTO cancer_patient(firstname,lastname,email,password) VALUES(?,?,?,?)";
    static final String detailsInsert = "INSERT INTO patient_details(firstname,lastname,gender,dob) VALUES(?,?,?,?)";

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
        ps = (PreparedStatement) connect.prepareStatement(insert);
        ps.setString(1, _firstname);
        ps.setString(2, _lastname);
        ps.setString(3, _email);
        ps.setString(4, _password);

        System.out.println(ps);

        ps.executeUpdate();
    }

    public void patientDetailsInsertion(String _firstname, String _lastname, String _gender, String _dob) throws SQLException {
        ps = (PreparedStatement) connect.prepareStatement(detailsInsert);
        ps.setString(1, _firstname);
        ps.setString(2, _lastname);
        ps.setString(3, _gender);
        ps.setString(4, _dob);

        System.out.println(ps);
        ps.executeUpdate();
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
