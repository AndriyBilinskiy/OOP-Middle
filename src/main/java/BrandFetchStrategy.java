import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class BrandFetchStrategy implements Strategy {
    @Override
    public CompanyInfo getData(String link) {
        try {
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.get(link).header("Authorization", "Bearer t9vuxOvjntawgEZsKxW53gmnRiUELR2LTx3mIsFsigE=")
                    .asString();
        } catch (UnirestException e) {
            throw new RuntimeException(e);
        }
//TODO
        return null ;
    }
}
