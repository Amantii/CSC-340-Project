package models;

/**
 * This is the parent class for any class that is going to make calls to the Appointment database API. By changing the one line of code,
 * the API that is being used can be changed for the entire system.
 *Updated December 1st, 2020
 * @author Imran Al NAfiee
 */
import apis.AppointmentAPIInterface;
import apis.AppointmentAPIAdapter;

public class APIBaseClass {

    // Here we designate the Translator that we want to use. In this case, the OpenMovieDatabaseAPITranslator.
    protected final static AppointmentAPIInterface myAppointment = new AppointmentAPIAdapter();

}
