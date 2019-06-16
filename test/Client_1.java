import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

// Odbieranie wiadomości
public class Client_1 {
    int port = 1234;
    String host = "127.0.0.1";
    String message;

    DatagramSocket socket;
    byte[] buf = new byte[256];

    public void run() throws Exception {
        socket = new DatagramSocket(port);
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        while (true) {
            socket.receive(packet);

            String received = new String(packet.getData(), 0, packet.getLength());
            
            System.out.println(received);
        }
    }

    public static void main(String args[]) {
        try {
            Client_1 client = new Client_1();
            client.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}