import java.net.*;
import java.util.Arrays;

public class UDPClient {

    public static void main(String[] args) {
        final int PORT = 5000;
        InetAddress host;
        try {
            host = InetAddress.getByName("localhost");
            DatagramSocket socket = new DatagramSocket();

            // send
            String msg = "anything";
            byte[] bSent = msg.getBytes();
            DatagramPacket packetSent = new DatagramPacket(bSent, bSent.length, host, PORT);
            socket.send(packetSent);

            // reception
            byte[] bReceived = new byte[1500];
            DatagramPacket packetRec = new DatagramPacket(bReceived, bReceived.length);

            socket.receive(packetRec);
            int nbCar = packetRec.getLength();
            byte[] tmp = Arrays.copyOf(bReceived, nbCar);
            String msgRec = new String(tmp, "UTF-8");

            System.out.println(msgRec);
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
