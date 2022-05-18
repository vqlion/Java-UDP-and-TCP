import java.net.*;
import java.util.Arrays;

public class UDPServer {

    public static void main(String[] args) {

        final int PORT = 5000;
        try {

            DatagramSocket socket = new DatagramSocket(PORT);

            System.out.println("socket opened on : " + InetAddress.getLocalHost() + " - port : " + PORT);

            byte[] b = new byte[1500];
            while (true) {
                DatagramPacket msg = new DatagramPacket(b, b.length);
                socket.receive(msg);

                int nbCar = msg.getLength();
                byte[] tmp = Arrays.copyOf(b, nbCar);
                String msgRec = new String(tmp, "UTF-8");

                System.out.println("message received by : " + msg.getAddress().toString() + " : " + msgRec);

                String msgSend = "anything";

                byte[] bSend = msgSend.getBytes();
                DatagramPacket packetSend = new DatagramPacket(bSend, bSend.length, msg.getAddress(), msg.getPort());
                socket.send(packetSend);
                // System.out.println("message sent : " + msgSend);
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
