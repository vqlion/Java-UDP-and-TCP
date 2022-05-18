import java.net.*;
import java.util.Arrays;
import java.io.*;

public class TCPClient {

    public static void main(String[] args) {
        final int PORT = 5000;
        Socket socket;
        try {
            socket = new Socket("localhost", PORT);

            // send
            String message = "anything";
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(message);

            // reception
            String msgRec;
            BufferedReader in;
            in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));

            msgRec = in.readLine();

            System.out.println(msgRec);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
