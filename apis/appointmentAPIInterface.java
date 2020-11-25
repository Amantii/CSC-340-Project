package apis;

/**
 * Grabs information from the appointment API
 *
 * Updated November 12, 2020
 *
 * @Author Imran Al Nafiee
 */
public interface appointmentAPIInterface {

    /**
     * Grabs the appointment information from the appointments API
     *
     * @param _response
     *
     * @return an Array String with the appointment information from the API
     */
    String getappointment(String _response);
}
