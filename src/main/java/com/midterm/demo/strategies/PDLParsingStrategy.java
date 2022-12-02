package com.midterm.demo.strategies;

import com.midterm.demo.company.CompanyInfo;
import com.midterm.demo.strategies.Strategy;
import lombok.SneakyThrows;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PDLParsingStrategy implements Strategy {
    @SneakyThrows
    public CompanyInfo getData(String link) {
        CompanyInfo response = new CompanyInfo();
        String API_KEY = "4534c57f1a35609e7e4f27c4755a83e696d54795078c3926496ec1cf4753743a";
        try {
            String query = URLEncoder.encode("SELECT NAME FROM COMPANY WHERE WEBSITE=" + "'" + link + "'", StandardCharsets.UTF_8);
            URL url = new URL("https://api.peopledatalabs.com/v5/company/search?sql=" + query);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-Api-Key", API_KEY);
            connection.connect();
            String text = new Scanner(connection.getInputStream()).useDelimiter("\\Z").next();
            JSONObject jsonObject = new JSONObject(text);

            response.setFacebook(String.valueOf(jsonObject.getJSONArray("data").getJSONObject(0).get("facebook_url")));
            response.setName(String.valueOf(jsonObject.getJSONArray("data").getJSONObject(0).get("name")));
            response.setAddress((String.valueOf(jsonObject.getJSONArray("data").getJSONObject(0).getJSONObject("location").get("street_address"))));
            response.setTwitter(String.valueOf(jsonObject.getJSONArray("data").getJSONObject(0).get("twitter_url")));
            response.setEmployees(String.valueOf(jsonObject.getJSONArray("data").getJSONObject(0).get("employee_count")));
        } catch (FileNotFoundException ignored){}
        return response;
    }
}
