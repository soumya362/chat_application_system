import java.io.*;
import java.net.*;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";  // Server IP address (localhost for local server)
    private static final int PORT = 12345;  // Server port

    public static void main(String[] args) {
        try {
            // 1. Connect to the server using a Socket (hostname, port)
            Socket socket = new Socket(SERVER_ADDRESS, PORT);
            System.out.println("Connected to the server.");

            // 2. Set up I/O streams to send and receive data
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter serverOutput = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while (true) {
                // 3. Read user input and send it to the server
                System.out.print("Enter message: ");
                message = userInput.readLine();
                serverOutput.println(message);  // Send message to the server

                // 4. Receive server response and display it
                String serverMessage = serverInput.readLine();
                System.out.println(serverMessage);  // Print server's response
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
