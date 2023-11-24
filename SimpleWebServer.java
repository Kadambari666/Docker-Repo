package CoreJava;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleWebServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server is running on port 8080...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleRequest(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket clientSocket) throws IOException {
        Scanner in = new Scanner(clientSocket.getInputStream());
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Read the HTTP request
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.isEmpty()) {
                break; // End of the request
            }
            System.out.println(line);
        }

        // Send a simple HTTP response
        out.println("HTTP/1.1 200 OK");
        out.println("Content-Type: text/html");
        out.println();
        out.println("<h1>Hello, this is a simple web server!</h1>");

        clientSocket.close();
    }
}

