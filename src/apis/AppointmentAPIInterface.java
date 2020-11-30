package apis;

/**
 * Grabs information from the appointment API
 *
 * Updated December 1st, 2020
 *
 * @Author Imran Al Nafiee
 */
public interface AppointmentAPIInterface {

    /**
     * Grabs the appointment information from the appointments API
     *
     *
     * @param _id
     * @return an Array String with the appointment information from the API
     */
    String getAppointments(String _id);

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
