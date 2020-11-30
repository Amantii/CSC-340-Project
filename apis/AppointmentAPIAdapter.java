package apis;

/**
 * appointment API Adapter class to make calls to the api given information from the AppointmentAPIAdapter.
 *
 *
 * Updated November 29th, 2020
 *
 * @Author Imran Al Nafiee
 */
import java.io.IOException;
import org.json.JSONException;

public class AppointmentAPIAdapter implements AppointmentAPIInterface {

    /**
     *
     * @param _id
     * @return
     * @throws IOException
     */
    @Override
    public  String getAppointments(String _id){
        String appointmentInfo;

        //Creates a new instance for the API request
        AppointmentApi appt = new AppointmentApi();

        //Grabs appointments from the API
        appointmentInfo = appt.getAppointments(_id);
        return appointmentInfo;

    }

    /**
     *
     * @param _id
     * @throws IOException
     * @throws JSONException
     */
    @Override
    public  void deleteAppointment(String _id) {

        AppointmentApi appt = new AppointmentApi();

        //deletes appointment by appointment ID
        appt.deleteAppointment(_id);

    }

    /**
     *
     * @param _startTime
     * @param _endTime
     * @param _title
     * @throws IOException
     * @throws JSONException
     */
    @Override
    public  void makeAppointment(String _startTime, String _endTime, String _title) {

        AppointmentApi appt = new AppointmentApi();

        appt.makeAppointment(_startTime, _endTime, _title);

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
    /*
    public static void createContact(String _firstname, String _lastname, String _email, String _cellphone) throws IOException, JSONException {

        AppointmentApi appt = new AppointmentApi();

        appt.createContact(_firstname, _lastname, _email, _cellphone);

    }
     */
    /**
     *
     * @param _contact_id
     * @return
     * @throws JSONException
     */
    /*
    public static Map getContact(String _contact_id) throws JSONException {

        Map contactInfo;

        //Creates a new instance for the API request
        AppointmentApi appt = new AppointmentApi();

        //Grabs appointments from the API
        contactInfo = appt.getContact(_contact_id);
        return contactInfo;

    }
     */
}
