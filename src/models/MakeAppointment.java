package models;

/**
 * Updated December 1st, 2020
 *
 * @author Imran Al Nafiee
 */
public class MakeAppointment extends APIBaseClass {

    protected String startTime;
    protected String endTime;
    protected String title;

    public void MakeAppointment() {
    }

    //=================  GETTERS ===============
    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getTitle() {
        return title;
    }
    //=================  SETTERS ===============

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
