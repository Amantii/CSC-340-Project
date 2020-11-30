package models;

/**
 *Updated December 1st, 2020
 *
 * @author Imran Al Nafiee
 */
public class GetAppointment extends APIBaseClass {

    protected String id;

    public void GetAppointment() {
    }
    //=================  GETTERS ===============

    public String getId() {
        return id;
    }

    //=================  SETTERS ===============
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @param _id
     * @return
     */
    public static GetAppointment getAppointments(String _id) {
        GetAppointment appt = new GetAppointment();
        appt.setId(_id);
        String id = GetAppointment.myAppointment.getAppointments(_id);
        if (id == null) {
            return null;
        }
        appt.setId(id);
        return appt;
    }

}
