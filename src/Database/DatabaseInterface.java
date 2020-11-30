package Database;

import java.util.Map;

/**
 *
 * @author Amantii
 */
public interface DatabaseInterface {

    public int createInsert(Map<String, String> _valuePairs, String _patientTable);
}
