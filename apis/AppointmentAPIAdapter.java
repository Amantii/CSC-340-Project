package apis;

/**
 * appointment API Adapter class to make calls to the api given information from the AppointmentAPIAdapter.
 *
 *
 * Updated December 1st, 2020
 *
 * @Author Imran Al Nafiee
 */
public class AppointmentAPIAdapter implements AppointmentAPIInterface {

    /**
     *
     * @param _id
     * @return
     */
    @Override
    public String getAppointments(String _id) {
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
     */
    @Override
    public String deleteAppointment(String _id) {
        String info;
        AppointmentApi appt = new AppointmentApi();

        //deletes appointment by appointment ID
        info = appt.deleteAppointment(_id);
        return info;
    }

    /**
     *
     * @param _startTime
     * @param _endTime
     * @param _title
     * @return
     */
    @Override
    public String makeAppointment(String _startTime, String _endTime, String _title) {
        String apptInfo;
        AppointmentApi appt = new AppointmentApi();

        apptInfo = appt.makeAppointment(_startTime, _endTime, _title);
        return apptInfo;
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
