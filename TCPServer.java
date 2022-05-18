import java.net.*;
import java.io.*;

public class TCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = null;
            int portNumber = 5000;
            serverSocket = new ServerSocket(portNumber);
            Socket clientSocket = null;
            String inputLine;

            while (true) {
                System.out.println("socket opened on : " + serverSocket.getInetAddress().getLocalHost());
                clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
                        true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                inputLine = in.readLine();

                System.out.println("message from client : " + clientSocket.getRemoteSocketAddress().toString()
                        + ": " + inputLine);
                System.out.println();
                String ans = "anything";
                out.println(ans);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
