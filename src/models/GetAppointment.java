package models;

import javafx.beans.property.SimpleStringProperty;

/**
 * Updated December 1st, 2020
 *
 * @author Imran Al Nafiee
 */
public class GetAppointment extends APIBaseClass {

    protected SimpleStringProperty id;

    
    public GetAppointment(String id) {
        this.id = new SimpleStringProperty(id);
    }
    //=================  GETTERS ===============

    public String getId() {
        return id.get();
    }

    //=================  SETTERS ===============
    public void setId(SimpleStringProperty id) {
        this.id = id;
    }

    /**
     *
     * @param _id
     * @return
     */
    /*
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
     */
}
