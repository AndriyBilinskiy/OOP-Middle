import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PDLParsingStrategy implements Strategy {
    public CompanyInfo getData(String link) throws IOException {
        CompanyInfo response = new CompanyInfo();
        String API_KEY = "";
//        String domain = response.getDomain()
        String query = URLEncoder.encode("SELECT NAME FROM COMPANY WHERE WEBSITE="+domain, StandardCharsets.UTF_8);
        URL url = new URL("https://api.peopledatalabs.com/v5/company/search?sql=" + query);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-Api-Key", API_KEY);
        connection.connect();
        String text = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
        JSONObject jsonObject = new JSONObject(text);
//        System.out.println(jsonObject);
        response.setEmployees(jsonObject.getJSONArray("data").getJSONObject(0).getInt("employee_count"));
    }
}
