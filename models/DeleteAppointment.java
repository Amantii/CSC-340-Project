package models;

/**
 * Updated December 1st, 2020
 *
 * @author Imran Al Nafiee
 */
public class DeleteAppointment extends APIBaseClass {

    protected String id;

    public void DeleteAppointment() {
    }
    //=================  GETTERS ===============

    public String getId() {
        return id;
    }

    //=================  SETTERS ===============
    public void setId(String id) {
        this.id = id;
    }

}
