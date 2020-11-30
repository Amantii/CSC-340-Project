package models;

/**
 *
 * @author Amantii
 */
public class MakeAppointment extends APIBaseClass {

    protected String startTime;
    protected String endTime;
    protected String title;

    public void Appointment() {
    }

    //=================  GETTERS ===============//

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getTitle() {
        return title;
    }

    //=================  SETTERS ===============//

    public void setStartTime(String _startTime) {
        this.startTime = _startTime;
    }

    public void setEndTime(String _endTime) {
        this.endTime = _endTime;
    }

    public void setTitle(String _title) {
        this.title = _title;
    }
}
