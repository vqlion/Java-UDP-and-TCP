import java.net.*;
import java.io.*;

public class TCPServer {
    public static void main(String[] args) {
        try {
            final int PORT = 5000;
            ServerSocket serverSocket = new ServerSocket(PORT); // opens the socket for the TCP communication on the
                                                                // specified port
            Socket clientSocket = null;
            String msgRec;
            System.out.println(
                    "socket opened on : " + serverSocket.getInetAddress().getLocalHost() + " - port : " + PORT);

            while (true) {
                clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); // to send messages
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                clientSocket.getInputStream())); // to receive messages

                msgRec = in.readLine(); // reads the message received from the client

                System.out.println("message from client : " + clientSocket.getRemoteSocketAddress().toString()
                        + ": " + msgRec);
                System.out.println();
                String ans = "anything";
                out.println(ans); // sends the answer

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
