import java.net.*;
import java.io.*;

public class TCPClient {

    public static void main(String[] args) {
        final int PORT = 5000;
        Socket socket;
        try {
            socket = new Socket("localhost", PORT); // establish communication with the server with the specified IP

            // send
            String message = "anything";
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // to send messages
            out.println(message); // sends a message to the server

            // receive
            String msgRec;
            BufferedReader in;
            in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream())); // to receive messages

            msgRec = in.readLine(); // reads the message received from the server

            System.out.println(msgRec);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
