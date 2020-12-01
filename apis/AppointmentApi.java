package apis;

/**
 * Class used to make calls to the www.yellowschedule.com.
 *
 * Updated December 1st, 2020
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
        //calls.deleteAppointment("apt_90TQ1E0MpNWWBlWS5MXO2c0MIFHMxB1b");
        //System.out.println(calls.getAppointment());
        //calls.makeAppointment("2020-12-01 11:00:00", "2020-12-01 11:30:00", "test");
    }

    /**
     * for testing
     *
     * @return
     */
    public Map getAppointment() {

        String urlString = yellowSchedule + callActionyellowSchedule;
        URL url;
        Map<String, String> apptData = new HashMap<>();

        //String apptData = null;
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
        } catch (JSONException ex) {
            Logger.getLogger(AppointmentApi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return apptData;
    }

    /**
     * to make appointment
     *
     * @param _startTime
     * @param _endTime
     * @param _title
     * @return
     */
    @Override
    public String makeAppointment(String _startTime, String _endTime, String _title) {

        String urlString = yellowSchedule + callActionyellowSchedule;
        URL url;
        String appt = "appointments?";
        String jsonData = "{\"start\":\"" + _startTime + "\",\"end\":\"" + _endTime + "\",\"title\":\"" + _title + "\",\"user_id\":\"usr_90zdaF1UYh3UjJzV0o3NxBTU4MXSXVVZ\"}";
        String info = null;

        urlString = urlString + appt;
        String responseResults = null;
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

            int status = connection.getResponseCode();
            responseResults = status + "";
            if (status != 200) {
                System.out.println("Appointment Already created");
            } else {
                System.out.println("Appointment is successfully created");
            }

            StringBuffer responseContent = new StringBuffer();
            try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                String inputLine;
                responseContent = new StringBuffer();

                //add all of the data to the inputLine until there is no more data
                while ((inputLine = inputStream.readLine()) != null) {
                    responseContent.append(inputLine);
                }

            }

            JSONObject obj = new JSONObject(responseContent.toString());

            info = (String) obj.get("created_appointment_id");

            System.out.println("created_appointment_id: " + info);

            //System.out.println(responseContent.toString()); // to print the respone body for testing.
            //appointments(responseContent.toString()); // to print the data for testing.
            connection.disconnect();
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        } catch (JSONException ex) {
            Logger.getLogger(AppointmentApi.class.getName()).log(Level.SEVERE, null, ex);
        }

        return info;

    }

    /**
     * Delete appointments
     *
     * @param _id
     */
    @Override
    public String deleteAppointment(String _id) {

        String urlString = yellowSchedule + callActionyellowSchedule;
        URL url;

        String appt = "appointments?" + "appointment_id=" + _id;
        urlString = urlString + appt;
        String responseResults = null;

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
            responseResults = status + "";
            if (status != 200) {
                System.out.println("Appointment Already Cancelled");
            } else {
                System.out.println("Appointment is Canclled");
            }
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

        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }
        return responseResults;
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
        /*String apptData = null;
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

        }*/

        Map<String, String> apptData = new HashMap<>();
        for (int i = 0; i < info.length(); i++) {
            JSONObject appointment = info.getJSONObject(i);
            String id = appointment.getString("id");
            apptData.put("AppointmetnId", id);
            String title = appointment.getString("title");
            apptData.put("title", title);
            String created = appointment.getString("created");
            apptData.put("created", created);
            String start = appointment.getString("start");
            apptData.put("start", start);
            String end = appointment.getString("end");
            apptData.put("end", end);
            String note = appointment.getString("note");
            apptData.put("note", note);

        }
        return apptData;

    }

}
