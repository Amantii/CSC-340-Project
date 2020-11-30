package models;

/**
 *
 * @author Amantii last updated: 11/29/20
 */

import apis.AppointmentAPIAdapter;
import apis.AppointmentAPIInterface;

public class APIBaseClass {

    protected final static AppointmentAPIInterface myAppointment = new AppointmentAPIAdapter();
}
