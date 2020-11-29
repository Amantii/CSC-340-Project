package apis;

/**
 * Grabs information from the appointment API
 *
 * Updated November 29th, 2020
 *
 * @Author Imran Al Nafiee
 */
import java.util.Map;
import org.json.JSONException;

public interface AppointmentAPIInterface {

    /**
     * Grabs the appointment information from the appointments API
     *
     * @param _appointmentId
     *
     * @return an Array String with the appointment information from the API
     */
    public static Map getAppointments(String _appointmentId) {

        return null;
    }

    /**
     * This is to make appointment method
     *
     * @param _startTime
     * @param _endTime
     * @param _title
     * @param _contact_id
     */
    public static void makeAppointment(String _startTime, String _endTime, String _title, String _contact_id) {

    }

    /**
     * This is to delete appointment method;
     *
     * @param _appointmentId
     */
    public static void deleteAppointment(String _appointmentId) {

    }

    /**
     * This is to create a user in api method
     *
     * @param _firstname
     * @param _lastname
     * @param _email
     * @param _cellphone
     */
    public static void createContact(String _firstname, String _lastname, String _email, String _cellphone) {

    }

    /**
     * Grabs the contact_id information from the contact API
     *
     * @param _contact_id
     * @return
     * @throws JSONException
     */
    public static Map getContact(String _contact_id) throws JSONException {

        return null;

    }

}
