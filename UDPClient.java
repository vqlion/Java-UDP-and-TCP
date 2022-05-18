import java.net.*;
import java.util.Arrays;

public class UDPClient {

    public static void main(String[] args) {
        final int PORT = 5000;
        InetAddress host;
        try {
            host = InetAddress.getByName("localhost");
            DatagramSocket socket = new DatagramSocket(); // opening the communication with the server with the
                                                          // specified IP

            // send
            String msg = "anything";
            byte[] bSent = msg.getBytes();
            DatagramPacket packetSent = new DatagramPacket(bSent, bSent.length, host, PORT); // create a packet that
                                                                                             // contains the message to
                                                                                             // send to the server
            socket.send(packetSent); // sends the message

            // receive
            byte[] bReceived = new byte[1500];
            DatagramPacket packetRec = new DatagramPacket(bReceived, bReceived.length); // create a packet that will
                                                                                        // contain the message received

            socket.receive(packetRec); // receive a message from the server and store it in packetRec
            int nbCar = packetRec.getLength();
            byte[] tmp = Arrays.copyOf(bReceived, nbCar);
            String msgRec = new String(tmp, "UTF-8"); // extract the string from packetRec

            System.out.println(msgRec);
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
