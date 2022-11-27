import java.io.IOException;

public interface Parser {
    public Response parse(String link) throws IOException;
}
