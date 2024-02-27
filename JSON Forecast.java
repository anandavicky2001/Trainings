import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Dell PC
 */
public class Forecast {

    /**
     * @param args the command line arguments
     * @throws java.net.MalformedURLException
     * @throws org.json.simple.parser.ParseException
     * @throws org.json.JSONException
     */
    public static void main(String[] args) throws MalformedURLException, IOException, ParseException, JSONException {

        JSONParser jsonParser = new JSONParser();
        try {

            String yourKey = "bd5e378503939ddaee76f12ad7a97608";
            URL url = new URL("https://api.openweathermap.org/data/2.5/forecast/daily?id=1642911&units=metric&cnt=7&appid=" + yourKey);
            URLConnection conn = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            System.out.println("Jakarta, Indonesia");
            System.out.println("Weather Forecast:");

            Object jsonObject = jsonParser.parse(reader);

            String jsonInString = new Gson().toJson(jsonObject);
            JSONObject jsonObj = new JSONObject(jsonInString);
            JSONArray daylist = jsonObj.getJSONArray("list");

            for (int i = 0; i <= 5; i++) {
                long weather = daylist.getJSONObject(i).getLong("dt");
                String temp = daylist.getJSONObject(i).getJSONObject("temp").getString("day");
                java.util.Date time = new java.util.Date((long) weather * 1000);
                String date = new SimpleDateFormat("E, DD MMM yyyy").format(time);
                System.out.println(date + ": " + temp + "\u00B0C");
            }

        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {
        }
    }
}
