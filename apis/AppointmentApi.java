package apis;

/**
 *
 * @Author Imran Al NAfiee
 *
 * Updated October 22, 2020
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppointmentApi {

    public static void main(String[] args) throws IOException, JSONException {

        String baseUrlyellowSchedule = "https://www.yellowschedule.com";
        String callActionyellowSchedule = "/app/api/v2/appointments?range_start=2020-09-20%2008:00:00&range_end=2020-10-30%2017:00:00";

        String urlString = baseUrlyellowSchedule + callActionyellowSchedule;
        URL url;
        try {

            // request setup
            url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            connection.setRequestProperty("Authorization", "Bearer " + API_Keys.Appointment());

            int status = connection.getResponseCode();
            //System.out.println(status);
            StringBuffer responseContent = new StringBuffer();
            try (BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                responseContent = new StringBuffer();

                //Appends all of the data to the inputLine until there is no more data
                while ((inputLine = inputStream.readLine()) != null) {
                    responseContent.append(inputLine);
                }
            }

            connection.disconnect();

            //System.out.println(responseContent.toString());
            //appointments(responseContent.toString()); // to print the data for testing.
        } catch (MalformedURLException e) {
        } catch (IOException e) {
        }

    }

    public static String appointments(String _response) throws JSONException {
        JSONObject obj = new JSONObject(_response);
        JSONArray schdule = obj.getJSONArray("appointments");
        for (int i = 0; i < schdule.length(); i++) {
            JSONObject appointment = schdule.getJSONObject(i);
            String id = appointment.getString("id");
            System.out.println("id: " + id);
            String userId = appointment.getString("user_id");
            System.out.println("user_id: " + userId);
            String title = appointment.getString("title");
            System.out.println("title: " + title);
            String date = appointment.getString("created");
            System.out.println("created date: " + date);
            String start = appointment.getString("start");
            System.out.println("start time: " + start);
            String end = appointment.getString("end");
            System.out.println("end time: " + end);
            String note = appointment.getString("note");
            System.out.println("note: " + note);
            String appointmentStatus = appointment.getString("contact_status");
            System.out.println("Satus: " + appointmentStatus);
        }
        return null;

    }

}
