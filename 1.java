import java.io.*;
import java.net.*;

public class ChatServer {
    private static final int PORT = 12345;  // Port to listen on
    
    public static void main(String[] args) {
        try {
            // 1. Create ServerSocket and start listening on PORT
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started. Waiting for client connection...");

            // 2. Accept incoming client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // 3. Set up I/O streams
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = input.readLine()) != null) {
                System.out.println("Client: " + clientMessage);  // Print message from client
                output.println("Server: " + clientMessage);     // Send response to client
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
