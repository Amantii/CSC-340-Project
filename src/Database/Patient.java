package Database;


public class Patient extends User {
    private String pat_id;
    public Patient(){
        super();
    }
    /*
    public Patient(String email, String password, int pat_id, String name, String surname) {
        super(email, password);
        this.pat_id = pat_id;
        this.name = name;
        this.surname = surname;
    }
*/

    public Patient(String pat_id, String first_name){
        this.pat_id = pat_id;
        this.firstname = first_name;
    }
    public void setPat_id(String pat_id) {
        this.pat_id = pat_id;

    }

    public String getPat_id() {
        return pat_id;
    }

    @Override
    public String toString() {
        return "Patient[ "+super.toString() + ", patient_id: "+pat_id+" ]";
    }

}
