package com.midterm.demo.strategies;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.midterm.demo.CompanyInfo;
import com.midterm.demo.Strategy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;


public class BrandFetchStrategy implements Strategy {
    @Override
    public CompanyInfo getData(String link) {
        CompanyInfo companyInfo = new CompanyInfo();
        try {
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.get("https://api.brandfetch.io/v2/brands/"+link).header("Authorization", "Bearer t9vuxOvjntawgEZsKxW53gmnRiUELR2LTx3mIsFsigE=")
                    .asString();
            JSONObject json = new JSONObject(response.getBody());
            companyInfo.setName(json.getString("name"));
            JSONArray links = json.getJSONArray("links");
            JSONArray logos = json.getJSONArray("logos");
            for (int i = 0; i < links.length(); i++){
                try {
                    JSONObject curLink = links.getJSONObject(i);
                    if (Objects.equals(curLink.getString("name"), "twitter")) {
                        companyInfo.setTwitter(curLink.getString("url"));
                    }
                    if (Objects.equals(curLink.getString("name"), "facebook")) {
                        companyInfo.setFacebook(curLink.getString("url"));
                    }
                }catch (JSONException ignored){}
            }
            for (int i = 0; i < logos.length(); i++) {
                JSONObject current = logos.getJSONObject(i);
                try {
                    if (Objects.equals(current.getString("type"), "logo")) {
                        companyInfo.setLogo(current.getJSONArray("formats").getJSONObject(0).getString("src"));
                    }
                    if (Objects.equals(current.getString("type"), "icon")) {
                        companyInfo.setIcon(current.getJSONArray("formats").getJSONObject(0).getString("src"));
                    }
                }catch (JSONException ignored){}
            }

            return companyInfo;

        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
    }
}
