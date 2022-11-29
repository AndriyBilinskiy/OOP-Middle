import java.io.IOException;

public interface Strategy {
    public CompanyInfo getData(String link) throws IOException;
}
