import java.net.*;
import java.util.Arrays;

public class UDPServer {

    public static void main(String[] args) {

        final int PORT = 5000;
        try {

            DatagramSocket socket = new DatagramSocket(PORT); // opens the socket for the UDP communication on the
                                                              // specified port

            System.out.println("socket opened on : " + InetAddress.getLocalHost() + " - port : " + PORT);

            byte[] b = new byte[1500];
            while (true) {
                DatagramPacket packetRec = new DatagramPacket(b, b.length); // create a packet that will contain the
                                                                            // message received
                socket.receive(packetRec); // receive a message from the client and store it in packetRec

                int nbCar = packetRec.getLength();
                byte[] tmp = Arrays.copyOf(b, nbCar);
                String msgRec = new String(tmp, "UTF-8"); // extract the string from packetRec

                System.out.println("message received by : " + packetRec.getAddress().toString() + " : " + msgRec);

                String msgSend = "anything";

                byte[] bSend = msgSend.getBytes();
                DatagramPacket packetSend = new DatagramPacket(bSend, bSend.length, packetRec.getAddress(),
                        packetRec.getPort());
                socket.send(packetSend); // send a message to the client
                // System.out.println("message sent : " + msgSend);
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
