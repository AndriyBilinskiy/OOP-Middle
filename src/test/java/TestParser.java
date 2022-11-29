import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class TestParser {
    public static void main(String[] args) throws UnirestException {

        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.get("https://api.brandfetch.io/v2/brands/bolt.eu").header("Authorization", "Bearer t9vuxOvjntawgEZsKxW53gmnRiUELR2LTx3mIsFsigE=")
                .asString();
        System.out.println(response.getBody());
    }
}
