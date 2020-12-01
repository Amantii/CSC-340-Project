package apis;

import java.util.Map;

/**
 * Grabs information from the appointment API
 *
 *
 * @author Imran Al Nafiee last updated: 12/01/20
 */
public interface AppointmentAPIInterface {

    /**
     * Grabs the appointment information from the appointments API
     *
     *
     * @return an Array String with the appointment information from the API
     */
    Map getAppointment();

    /**
     * This is to make appointment method
     *
     * @param _startTime
     * @param _endTime
     * @param _title
     * @return
     */
    String makeAppointment(String _startTime, String _endTime, String _title);

    /**
     * This is to delete appointment method;
     *
     * @param _appointmentId
     * @return
     */
    String deleteAppointment(String _appointmentId);

    /**
     * This is to create a user in api method
     *
     * @param _firstname
     * @param _lastname
     * @param _email
     * @param _cellphone
     */
    /*
    public static void createContact(String _firstname, String _lastname, String _email, String _cellphone) {

    }*/
    /**
     * Grabs the contact_id information from the contact API
     *
     * @param _contact_id
     * @return
     * @throws JSONException
     */
    /*
    public static Map getContact(String _contact_id) throws JSONException {

        return null;

    }*/
}
