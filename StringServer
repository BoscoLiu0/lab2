import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class StringServer {

    private static String runningString = "";

    public static void main(String[] args) {
        Spark.port(4567);

        Spark.get("/add-message", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                String message = request.queryParams("s");
                if (message != null && !message.isEmpty()) {
                    runningString += (runningString.isEmpty() ? "" : "\n") +
                            (runningString.split("\n").length + 1) + ". " + message;
                }
                return runningString;
            }
        });
    }
}
