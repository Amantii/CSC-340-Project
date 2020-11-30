package Database;

import apis.AppointmentAPIAdapter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

/**
 *
 * @author Amantii
 */
public class DatabaseConnect {

    Connection connect = null;
    Statement statement = null;

    static String host = "jdbc:mysql://localhost:3306/cancerApp";
    static String username = "root";
    static String password = "root";

    public DatabaseConnect() {
        //this.connect();
    }

    /*
    public int createInsert(Map<String, String> _valuePairs, String _patientTable) {

        String query = "INSERT INTO " + _patientTable;
        String name = "(";
        String value = "VALUES (";
        for (Map.Entry<String, String> entry : _valuePairs.entrySet()) {
            name += " `" + entry.getKey() + "`, ";
            value += " '" + entry.getValue() + "', ";
        }
        name = name.substring(0, name.length() - 2);
        value = value.substring(0, value.length() - 2);
        name += ") ";
        value += ") ";
        query += name + value;
        int newKey = this.causeInsert(query);
        if (newKey == -1) {
            System.out.println("Database Error: Could not create new record");
            return 0;
        }
        return newKey;
    }

    public int causeInsert(String _query) {
        int key = -1;
        try {
            this.statement.executeUpdate(_query, Statement.RETURN_GENERATED_KEYS);
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                key = result.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Query Error: " + ex.getMessage());
            Logger.getLogger(AppointmentAPIAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }

    protected ResultSet runQuery(String _query) {
        ResultSet result = null;
        try {
            result = statement.executeQuery(_query);
        } catch (SQLException ex) {
            System.out.println("Query Error: " + ex.getMessage());
        }
        return result;
    }

    private void connect() {
        try {
            this.connect = (Connection) DriverManager.getConnection(DatabaseConnect.host, DatabaseConnect.username, DatabaseConnect.password);
            this.statement = (Statement) connect.createStatement();
        } catch (SQLException ex) {
            System.out.println("Cannot connect to Database: " );
        }
    }
*/
}
