import spark.Request;
import spark.Response;
import spark.Route;
import spark.utils.IOUtils;
import static spark.Spark.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class Main {
    public static void main(String[] args) throws IOException {
        get(new Route("/cuadrado") {
            @Override
            public Object handle(Request req, Response res) {
                String id = req.queryParams("num");
                try{
                URL url = new URL("https://n7v1mcktua.execute-api.us-east-1.amazonaws.com/version1?num=" + Integer.parseInt(id));
                URLConnection con = url.openConnection();
                InputStream in = con.getInputStream();
                String body = IOUtils.toString(in);
                return (body);
                }catch (Exception e){
                    return ("error");
                }
            }
        });
    }
}
