package Database;

/**
 *
 * @author Amantii
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    Connection connect = null;

    public static Connection dbConnect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_DB", "root", "password");
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ConnectDB: " + ex.getMessage());
            return null;
        }
    }
}
