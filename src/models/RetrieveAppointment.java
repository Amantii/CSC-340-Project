package models;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Amantii
 */
public class RetrieveAppointment {

    protected SimpleStringProperty apptID;
    protected SimpleStringProperty title;
    protected SimpleStringProperty startTime;
    protected SimpleStringProperty endTime;
    protected SimpleStringProperty note;

    public RetrieveAppointment(String apptID, String title, String startTime, String endTime, String note) {
        this.apptID = new SimpleStringProperty(apptID);
        this.title = new SimpleStringProperty(title);
        this.startTime = new SimpleStringProperty(startTime);
        this.endTime = new SimpleStringProperty(endTime);
        this.note = new SimpleStringProperty(note);
    }

    public String getApptID() {
        return apptID.get();
    }

    public String getTitle() {
        return title.get();
    }

    public String getStartTime() {
        return startTime.get();
    }

    public String getEndTime() {
        return endTime.get();
    }

    public String getNote() {
        return note.get();
    }

    public void setApptID(SimpleStringProperty apptID) {
        this.apptID = apptID;
    }

    public void setTitle(SimpleStringProperty title) {
        this.title = title;
    }

    public void setEndTime(SimpleStringProperty endTime) {
        this.endTime = endTime;
    }

    public void setNote(SimpleStringProperty note) {
        this.note = note;
    }

}
