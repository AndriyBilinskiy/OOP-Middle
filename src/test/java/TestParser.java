import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;
import java.util.Objects;


public class TestParser {
    public static void main(String[] args) throws UnirestException {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://api.brandfetch.io/v2/brands/www.tesla.com").header("Authorization", "Bearer t9vuxOvjntawgEZsKxW53gmnRiUELR2LTx3mIsFsigE=")
                .asString();
        String stringResponse = response.getBody();
        JSONObject json = new JSONObject(stringResponse);
        JSONArray links = json.getJSONArray("links");
        for (int i = 0; i < links.length(); i++){
            JSONObject curLink = links.getJSONObject(i);
            if (Objects.equals(curLink.getString("name"), "twitter")){
                System.out.println(curLink.getString("url"));
            }
        }
        System.out.println(response.getBody());
    }
}
