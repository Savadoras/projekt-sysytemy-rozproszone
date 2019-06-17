import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

// Odbieranie wiadomości
public class Client_1 {
    int port = 12345;

    DatagramSocket socket;
    byte[] buf = new byte[256];

    public void run() {
        try {
            socket = new DatagramSocket(port);

            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            
            // odbieranie i wyświetlanie wiadomości
            while (true) {
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.print(received);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {

        System.out.println("====================");
        System.out.println("    Aplikacja #3");
        System.out.println("====================");

        try {
            Client_1 client = new Client_1();
            client.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}