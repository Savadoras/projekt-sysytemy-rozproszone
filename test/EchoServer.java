import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

// Wysyłanie wiadomości
public class EchoServer {
    private DatagramSocket socket;
    private InetAddress address;
    private byte[] buf;

    public EchoServer() throws Exception {
        socket = new DatagramSocket();
        address = InetAddress.getByName("localhost");
    }

    public void sendEcho(String msg) throws Exception{
        buf = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 1234);
        socket.send(packet);
    }

    public static void main(String[] args) {
        try {
            EchoServer echoServer = new EchoServer();
            echoServer.sendEcho("==================================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}