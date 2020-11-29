package apis;

/**
 * Class used to make calls to the www.yellowschedule.com.
 *
 * Updated November 29th, 2020
 *
 *
 * @Author Imran Al Nafiee
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppointmentApi implements AppointmentAPIInterface {

    /**
     *
     * @param args
     * @throws IOException
     * @throws JSONException
     */
    private static final String yellowSchedule = "https://www.yellowschedule.com";
    private static final String callActionyellowSchedule = "/app/api/v2/";

    //range_start=2020-09-20%2008:00:00&range_end=2020-12-30%2017:00:00
    /**
     * Main
     *
     * @param args
     * @throws IOException
     * @throws JSONException
     */
    public static void main(String[] args) throws IOException, JSONException {

        //createContact("Subaru", "STI", "sti@gmail.com", "123456789");
        //deleteAppointment("apt_90zZJ9mQm9ST6FjVVpWORF2YBBTUnZlb");
        //System.out.println(getAppointments("apt_90TU1smdGhmcmdzQChEWkJVVQFjQR5kZ"));
        //System.out.println(getAppointment2());
        //makeAppointment("2020-11-27 09:00:00", "2020-11-27 09:30:00", "test", "con_90TUyRGcJR3V5wUTOR0LwY1SvlzcxpmV");
        //System.out.println(getContact2());
        //System.out.println(getContact("con_90TUyRGcJR3V5wUTOR0LwY1SvlzcxpmV"));
    }

    /**
     * This method is to create new contact in the api.
     *
     * @param _firstname
     * @param _lastname
     * @param _email
     * @param _cellphone
     * @throws IOException
     * @throws JSONException
     */
    public static void createContact(String _firstname, String _lastname, String _email, String _cellphone) throws IOException, JSONException {

        String urlString = yellowSchedule + callActionyellowSchedule;
        URL url;

        String contact = "contacts?";
        String jsonData = "{\"firstname\":\"" + _firstname + "\",\"lastname\":\"" + _lastname + "\",\"email\":\"" + _email + "\",\"user_id\":\"usr_90zdaF1UYh3UjJzV0o3NxBTU4MXSXVVZ\"}";
        urlString = urlString + contact;

        try {

            //request setup
            url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");

            connection.setUseCaches(false);
            //connection time out after 5 seconds.
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestProperty("Authorization", "Bearer " + API_Keys.Appointment());

            connection.setDoOutput(true);
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonData.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();

            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post apptId : " + jsonData);
            System.out.println("Response Code : " + responseCode);

            StringBuffer responseContent = new StringBuffer();
            try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                String inputLine;
                responseContent = new StringBuffer();

                //add all of the data to the inputLine until there is no more data
                while ((inputLine = inputStream.readLine()) != null) {
                    responseContent.append(inputLine);
                }

            }

            connection.disconnect();

            //System.out.println(responseContent.toString()); // to print the respone body for testing.
            //appointments(responseContent.toString()); // to print the data for testing.
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }

    }

    /**
     * This method is to get contact id from contact api.
     *
     * @param _contact_id
     * @return @throws JSONException
     */
    public static Map getContact(String _contact_id) throws JSONException {
        String urlString = yellowSchedule + callActionyellowSchedule;
        URL url;

        String contact = "contacts?" + "contact_id=" + _contact_id;
        urlString = urlString + contact;
        Map<String, String> contactData = new HashMap<>();
        try {

            //request setup
            url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //connection time out after 5 seconds.
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestProperty("Authorization", "Bearer " + API_Keys.Appointment());

            int status = connection.getResponseCode();
            //System.out.println(status); // to print the status for testing.
            StringBuffer responseContent = new StringBuffer();
            try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                responseContent = new StringBuffer();

                //add all of the data to the inputLine until there is no more data
                while ((inputLine = inputStream.readLine()) != null) {
                    responseContent.append(inputLine);
                }
            }

            connection.disconnect();

            //System.out.println(responseContent.toString());
            contactData = contacts(responseContent.toString()); // to print the data for testing.

        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }

        return contactData;

    }

    /**
     * for testing
     *
     * @return @throws JSONException
     */
    /*
    public static Map getContact2() throws JSONException {
        String urlString = yellowSchedule + callActionyellowSchedule;
        URL url;

        String contactIfno = "contacts?";
        urlString = urlString + contactIfno;
        Map<String, String> contactData = new HashMap<>();
        try {

            //request setup
            url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //connection time out after 5 seconds.
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestProperty("Authorization", "Bearer " + API_Keys.Appointment());

            int status = connection.getResponseCode();
            //System.out.println(status); // to print the status for testing.
            StringBuffer responseContent = new StringBuffer();
            try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                responseContent = new StringBuffer();

                //add all of the data to the inputLine until there is no more data
                while ((inputLine = inputStream.readLine()) != null) {
                    responseContent.append(inputLine);
                }
            }

            connection.disconnect();

            //System.out.println(responseContent.toString()); // to print the respone body for testing.
            contactData = contacts(responseContent.toString()); // to print the data for testing.

        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }

        return contactData;

    }
     */
    /**
     * This method is to get appointment information from the api
     *
     * @param _appointmentId
     * @return
     * @throws IOException
     * @throws JSONException
     */
    public static Map getAppointments(String _appointmentId) throws IOException, JSONException {

        String urlString = yellowSchedule + callActionyellowSchedule;
        URL url;

        String appt = "appointments?" + "appointment_id=" + _appointmentId;
        urlString = urlString + appt;
        Map<String, String> apptData = new HashMap<>();
        try {

            //request setup
            url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //connection time out after 5 seconds.
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestProperty("Authorization", "Bearer " + API_Keys.Appointment());

            int status = connection.getResponseCode();
            //System.out.println(status); // to print the status for testing.
            StringBuffer responseContent = new StringBuffer();
            try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                responseContent = new StringBuffer();

                //add all of the data to the inputLine until there is no more data
                while ((inputLine = inputStream.readLine()) != null) {
                    responseContent.append(inputLine);
                }
            }

            connection.disconnect();

            //System.out.println(responseContent.toString()); // to print the respone body for testing.
            apptData = appointments(responseContent.toString()); // to print the data for testing.

        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }

        return apptData;
    }

    /**
     * for testing
     *
     * @return
     * @throws IOException
     * @throws JSONException
     */
    /*
    public static Map getAppointment2() throws IOException, JSONException {

        String urlString = yellowSchedule + callActionyellowSchedule;
        URL url;

        String apptId = "appointments?" + "range_start=2020-09-20%2008:00:00&range_end=2020-12-30%2017:00:00";
        urlString = urlString + apptId;
        Map<String, String> apptData = new HashMap<>();
        try {

            //request setup
            url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            //connection time out after 5 seconds.
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestProperty("Authorization", "Bearer " + API_Keys.Appointment());

            int status = connection.getResponseCode();
            //System.out.println(status); // to print the status for testing.
            StringBuffer responseContent = new StringBuffer();
            try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                responseContent = new StringBuffer();

                //add all of the data to the inputLine until there is no more data
                while ((inputLine = inputStream.readLine()) != null) {
                    responseContent.append(inputLine);
                }
            }

            connection.disconnect();

            //System.out.println(responseContent.toString()); // to print the respone body for testing.
            apptData = appointments(responseContent.toString()); // to print the data for testing.
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return apptData;
    }
     */
    /**
     * to make appointment
     *
     * @param _startTime
     * @param _endTime
     * @param _title
     * @param _contact_id
     * @throws IOException
     * @throws JSONException
     */
    public static void makeAppointment(String _startTime, String _endTime, String _title, String _contact_id) throws IOException, JSONException {

        String urlString = yellowSchedule + callActionyellowSchedule;
        URL url;
        String appt = "appointments?";
        String jsonData = "{\"start\":\"" + _startTime + "\",\"end\":\"" + _endTime + "\",\"title\":\"" + _title + "\",\"contact_id\":\"" + _contact_id + "\",\"user_id\":\"usr_90zdaF1UYh3UjJzV0o3NxBTU4MXSXVVZ\"}";

        urlString = urlString + appt;

        try {

            url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");

            connection.setRequestProperty("Content-Type", "application/json; utf-8");
            connection.setRequestProperty("Accept", "application/json");

            connection.setUseCaches(false);
            //connection time out after 5 seconds.
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestProperty("Authorization", "Bearer " + API_Keys.Appointment());

            connection.setDoOutput(true);
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonData.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Post apptId : " + jsonData);
            System.out.println("Response Code : " + responseCode);

            StringBuffer responseContent = new StringBuffer();
            try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                String inputLine;
                responseContent = new StringBuffer();

                //add all of the data to the inputLine until there is no more data
                while ((inputLine = inputStream.readLine()) != null) {
                    responseContent.append(inputLine);
                }

            }

            connection.disconnect();

            //System.out.println(responseContent.toString()); // to print the respone body for testing.
            //appointments(responseContent.toString()); // to print the data for testing.
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }

    }

    /**
     * Delete appointments
     *
     * @param _appointmentId
     * @throws IOException
     * @throws JSONException
     */
    public static void deleteAppointment(String _appointmentId) throws IOException, JSONException {

        String urlString = yellowSchedule + callActionyellowSchedule;
        URL url;

        String appt = "appointments?" + "appointment_id=" + _appointmentId;
        urlString = urlString + appt;

        try {

            //request setup
            url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            //connection time out after 5 seconds.
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestProperty("Authorization", "Bearer " + API_Keys.Appointment());

            int status = connection.getResponseCode();
            //System.out.println(status); // to print the status for testing.
            StringBuffer responseContent = new StringBuffer();
            try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                responseContent = new StringBuffer();

                //add all of the data to the inputLine until there is no more data
                while ((inputLine = inputStream.readLine()) != null) {
                    responseContent.append(inputLine);
                }
            }

            connection.disconnect();

            //System.out.println(responseContent.toString()); // to print the respone body for testing.
            appointments(responseContent.toString()); // to print the data for testing.

        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }

    }

    /**
     * This method to present the appointment information
     *
     * @param _response
     * @return
     * @throws JSONException
     */
    public static Map appointments(String _response) throws JSONException {
        JSONObject obj = new JSONObject(_response);
        JSONArray info = obj.getJSONArray("appointments");
        Map<String, String> apptData = new HashMap<>();
        for (int i = 0; i < info.length(); i++) {
            JSONObject appointment = info.getJSONObject(i);
            String id = appointment.getString("id");
            apptData.put("appointment_id", id);
            //String user_id = appointment.getString("user_id");
            //apptData.put("user_id", user_id);
            String title = appointment.getString("title");
            apptData.put("title", title);
            String date = appointment.getString("created");
            apptData.put("created date", date);
            String start = appointment.getString("start");
            apptData.put("start time", start);
            String end = appointment.getString("end");
            apptData.put("end time", end);
            String note = appointment.getString("note");
            apptData.put("note", note);
            //String appointmentStatus = appointment.getString("contact_status");
            //apptData = apptData + "Satus: " + appointmentStatus + "\n";

        }
        return apptData;

    }

    /**
     * This method is to present the contact Id.
     *
     * @param _contactResponse
     * @return
     * @throws JSONException
     */
    public static Map contacts(String _contactResponse) throws JSONException {
        JSONObject obj = new JSONObject(_contactResponse);
        JSONArray user = obj.getJSONArray("contacts");
        Map<String, String> contactData = new HashMap<>();
        for (int i = 0; i < user.length(); i++) {
            JSONObject contacts = user.getJSONObject(i);
            String contact_id = contacts.getString("contact_id");
            contactData.put("contact_id", contact_id);

        }
        return contactData;

    }

}
