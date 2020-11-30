package Database;

public class Doctor extends User {
    private String doc_id;
    public Doctor(){
        super();
    }
    public Doctor(String email, String password, String pat_id, String firstname, String surname) {
        //super(email, password);
        this.doc_id = pat_id;
        this.firstname = firstname;
        //this.surname = surname;
    }

    public Doctor(String pat_id, String first_name){
        this.doc_id = pat_id;
        this.firstname = first_name;
    }
    public void setDoc_id(String pat_id) {
        this.doc_id = pat_id;

    }

    public String getDoc_id() {
        return doc_id;
    }

    @Override
    public String toString() {
        return "Patient[ "+super.toString() + ", doctor_id: "+doc_id+" ]";
    }

}
