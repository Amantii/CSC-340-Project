package Database;

public class User {

    protected int patientID;
    protected String firstname;
    protected String lastname;
    protected String email;
    protected String password;

    public User() {
    }

    public int getID() {
        return patientID;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setID(int _patientID) {
        this.patientID = _patientID;
    }

    public void setFirstName(String _firstname) {
        this.firstname = _firstname;
    }

    public void setLastName(String _lastname) {
        this.lastname = _lastname;
    }

    public void setEmail(String _email) {
        this.email = _email;
    }

    public void setPassword(String _password) {
        this.password = _password;
    }

    @Override
    public String toString() {
        return "cancer_patient [id = "+patientID+", firstname = "+firstname+", lastname = "+lastname+", email = "+email+", password = "+password+"]";
    }

}
