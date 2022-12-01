package com.midterm.demo.strategies;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.PlaceDetailsRequest;
import com.google.maps.TextSearchRequest;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlacesSearchResponse;
import lombok.SneakyThrows;
import com.midterm.demo.CompanyInfo;

public class GoogleSearchStrategy implements Strategy {
    @Override
    @SneakyThrows
    public CompanyInfo getData(String link) {
        CompanyInfo companyInfo = new CompanyInfo();
        String API_KEY = "AIzaSyBfBlVG42ffc66QM5e6a8z5H_41jZ69TRo";
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(API_KEY)
                .build();
        PlacesSearchResponse placesResponse = new TextSearchRequest(context).query(link).await();
        try {
            companyInfo.setAddress(placesResponse.results[0].formattedAddress);
            companyInfo.setName(placesResponse.results[0].name);
            companyInfo.setIcon(placesResponse.results[0].icon.toString());
            context.shutdown();
        }catch (ArrayIndexOutOfBoundsException ignored){}
        return companyInfo;
    }
}
