class SimpleStringServer {

    private static String runningString = "";

    public static void main(String[] args) {
        try {
            java.net.ServerSocket serverSocket = new java.net.ServerSocket(8080);
            System.out.println("Server listening on port 8080...");

            while (true) {
                java.net.Socket clientSocket = serverSocket.accept();
                handleRequest(clientSocket);
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(java.net.Socket clientSocket) {
        try (
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(clientSocket.getInputStream()));
            java.io.OutputStream output = clientSocket.getOutputStream()
        ) {
            String request = reader.readLine();
            String message = getMessageFromRequest(request);

            if (message != null && !message.isEmpty()) {
                runningString += (runningString.isEmpty() ? "" : "\n") +
                        (runningString.split("\n").length + 1) + ". " + message;
            }

            String response = "HTTP/1.1 200 OK\r\n\r\n" + runningString;
            output.write(response.getBytes());
            output.flush();

            clientSocket.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private static String getMessageFromRequest(String request) {
        // Extract the message parameter from the request
        // This is a simple example and may need improvement for production use
        if (request != null && request.startsWith("GET /add-message")) {
            int startIndex = request.indexOf("s=");
            if (startIndex != -1) {
                int endIndex = request.indexOf(" ", startIndex);
                if (endIndex != -1) {
                    return request.substring(startIndex + 2, endIndex);
                }
            }
        }
        return null;
    }
}
