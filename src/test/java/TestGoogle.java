import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.PlaceDetailsRequest;
import com.google.maps.TextSearchRequest;
import com.google.maps.model.PlaceDetails;
import com.google.maps.model.PlacesSearchResponse;
import lombok.SneakyThrows;

public class TestGoogle {
    @SneakyThrows
    public static void main(String[] args) {
        String API_KEY = "AIzaSyBfBlVG42ffc66QM5e6a8z5H_41jZ69TRo";
        String query = "Bolt";
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(API_KEY)
                .build();
        PlacesSearchResponse placesRespose = new TextSearchRequest(context).query(query).await();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String address = placesRespose.results[0].formattedAddress;
        String placeId = placesRespose.results[0].placeId;
        String icon = placesRespose.results[0].icon.toString();

        PlaceDetails placeDetails = new PlaceDetailsRequest(context).placeId(placeId).await();
//        System.out.println(gson.toJson(placeDetails.toString()));
        System.out.format("Icon",  icon);
//        System.out.format(String.valueOf(placesRespose.results[0].toString()));

        context.shutdown();
    }
}
