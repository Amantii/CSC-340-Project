package apis;

import java.io.IOException;
import java.util.Map;
import org.json.JSONException;

/**
 * appointment API Adapter class to make calls to the api given information from the AppointmentAPIAdapter.
 *
 *
 * Updated November 29th, 2020
 *
 * @Author Imran Al Nafiee
 */
public class AppointmentAPIAdapter implements appointmentAPIInterface {

    /**
     *
     * @param _appointmentId
     * @return
     * @throws JSONException
     * @throws IOException
     */
    public static Map getAppointments(String _appointmentId) throws JSONException, IOException {
        Map appointmentInfo;

        //Creates a new instance for the API request
        AppointmentApi appt = new AppointmentApi();

        //Grabs appointments from the API
        appointmentInfo = appt.getAppointments(_appointmentId);
        return appointmentInfo;

    }

    /**
     *
     * @param _appointmentId
     * @throws IOException
     * @throws JSONException
     */
    public static void deleteAppointment(String _appointmentId) throws IOException, JSONException {

        AppointmentApi appt = new AppointmentApi();

        //deletes appointment by appointment ID
        appt.deleteAppointment(_appointmentId);

    }

    /**
     *
     * @param _startTime
     * @param _endTime
     * @param _title
     * @param _contact_id
     * @throws IOException
     * @throws JSONException
     */
    public static void makeAppointment(String _startTime, String _endTime, String _title, String _contact_id) throws IOException, JSONException {

        AppointmentApi appt = new AppointmentApi();

        appt.makeAppointment(_startTime, _endTime, _title, _contact_id);

    }

    /**
     *
     * @param _firstname
     * @param _lastname
     * @param _email
     * @param _cellphone
     * @throws IOException
     * @throws JSONException
     */
    public static void createContact(String _firstname, String _lastname, String _email, String _cellphone) throws IOException, JSONException {

        AppointmentApi appt = new AppointmentApi();

        appt.createContact(_firstname, _lastname, _email, _cellphone);

    }

    /**
     *
     * @param _contact_id
     * @return
     * @throws JSONException
     */
    public static Map getContact(String _contact_id) throws JSONException {

        Map contactInfo;

        //Creates a new instance for the API request
        AppointmentApi appt = new AppointmentApi();

        //Grabs appointments from the API
        contactInfo = appt.getContact(_contact_id);
        return contactInfo;

    }

}
