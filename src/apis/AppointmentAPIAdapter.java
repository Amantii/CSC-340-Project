package apis;

import java.util.Map;

/**
 * appointment API Adapter class to make calls to the api given information from the AppointmentAPIAdapter.
 *
 *
 *
 *
 * @Author Imran Al Nafiee
 *
 * last updated: 12/01/20
 */
public class AppointmentAPIAdapter implements AppointmentAPIInterface {

    /**
     *
     * @return
     */
    public Map getAppointment() {
        Map appointmentInfo;

        //Creates a new instance for the API request
        AppointmentApi appt = new AppointmentApi();

        //Grabs appointments from the API
        appointmentInfo = appt.getAppointment();
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

}
