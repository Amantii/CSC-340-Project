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
import java.util.logging.Level;
import java.util.logging.Logger;
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
        AppointmentApi calls = new AppointmentApi();
        //createContact("Subaru", "STI", "sti@gmail.com", "123456789");
        calls.deleteAppointment("apt_90TUBlFd5U2QrcGRVJWapJXYaNnWlF1N");
        //calls.getAppointments("apt_90TUPxmZPVUe25mVqFmRNh2ZNhnarBHc");
        //System.out.println(getAppointment2());
        //calls.makeAppointment("2020-12-01 09:00:00", "2020-12-01 09:30:00", "test");  
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
    /*
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
     */
    /**
     * This method is to get contact id from contact api.
     *
     * @param _contact_id
     * @return @throws JSONException
     */
    /*
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
     */
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
     * @param _id
     * @return
     */
    @Override
    public String getAppointments(String _id) {

        String urlString = yellowSchedule + callActionyellowSchedule;
        URL url;
        String apptData = null;
        String appt = "appointments?" + "appointment_id=" + _id;
        urlString = urlString + appt;
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
        } catch (JSONException ex) {
            Logger.getLogger(AppointmentApi.class.getName()).log(Level.SEVERE, null, ex);
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
    public static String getAppointment2() throws IOException, JSONException {

        String urlString = yellowSchedule + callActionyellowSchedule;
        URL url;
        String apptData = null;
        String apptId = "appointments?" + "range_start=2020-09-20%2008:00:00&range_end=2020-12-30%2017:00:00";
        urlString = urlString + apptId;

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
     * to make appointment
     *
     * @param _startTime
     * @param _endTime
     * @param _title
     */
    @Override
    public void makeAppointment(String _startTime, String _endTime, String _title) {

        String urlString = yellowSchedule + callActionyellowSchedule;
        URL url;
        String appt = "appointments?";
        String jsonData = "{\"start\":\"" + _startTime + "\",\"end\":\"" + _endTime + "\",\"title\":\"" + _title + "\",\"user_id\":\"usr_90zdaF1UYh3UjJzV0o3NxBTU4MXSXVVZ\"}";

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
     * @param _id
     */
    @Override
    public void deleteAppointment(String _id) {

        String urlString = yellowSchedule + callActionyellowSchedule;
        URL url;

        String appt = "appointments?" + "appointment_id=" + _id;
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
        } catch (JSONException ex) {
            Logger.getLogger(AppointmentApi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method to present the appointment information
     *
     * @param _response
     * @return
     * @throws JSONException
     */
    public static String appointments(String _response) throws JSONException {
        JSONObject obj = new JSONObject(_response);
        JSONArray info = obj.getJSONArray("appointments");
        String apptData = null;
        for (int i = 0; i < info.length(); i++) {
            JSONObject appointment = info.getJSONObject(i);
            apptData = appointment.getString("id");
            System.out.println("Appointment Id: " + apptData);
            apptData = appointment.getString("title");
            System.out.println("title: " + apptData);
            apptData = appointment.getString("created");
            System.out.println("created: " + apptData);
            apptData = appointment.getString("start");
            System.out.println("start: " + apptData);
            apptData = appointment.getString("end");
            System.out.println("end: " + apptData);
            apptData = appointment.getString("note");
            System.out.println("note: " + apptData);
            System.out.println(" ");

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
