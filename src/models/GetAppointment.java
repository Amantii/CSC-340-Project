package models;

/**
 *
 * @author Amantii
 */
public class GetAppointment extends APIBaseClass {

    protected String appointmentId;

    public void GetAppointment() {
    }

    //=================  GETTERS ===============//

    public String getAppointment() {
        return appointmentId;
    }

    //=================  SETTERS ===============//

    public void setAppointment(String appointmentId) {
        this.appointmentId = appointmentId;
    }
}
