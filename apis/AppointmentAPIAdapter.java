package apis;

import org.json.JSONException;

/**
 * appointment API Adapter class to make calls to the api given information from
 * the AppointmentAPIAdapter.
 *
 *
 * Updated November 12, 2020
 *
 * @Author Imran Al Nafiee
 */
public class AppointmentAPIAdapter {

    public static String appointments(String _response) throws JSONException {
        String appointmentInfo;

        //Creates a new instance for the API request
        AppointmentAPIAdapter getAppointments = new AppointmentAPIAdapter();

        //Grabs appointments from the API
        appointmentInfo = getAppointments.appointments(_response);
        return appointmentInfo;

    }

}
