package app;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class App {

    int port = 12345;
    String outIp = "127.0.0.1";
    // Adres do publikacji pliku wsdl
    String url = "http://localhost:" + port + "/";

    InetAddress address;
    DatagramSocket socket;
    private byte[] buf;

    public App() {
        try {
            socket = new DatagramSocket();
            address = InetAddress.getByName(outIp);
        } catch (UnknownHostException| SocketException e) {
            e.printStackTrace();
        }
    }
    
    // Wysyłanie danych na socket
    @WebMethod(operationName = "sendOver")
    public void sendOver(String msg) {
        buf = msg.getBytes();

        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
        try {
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(".");
    }

    public static void main(String[] args) {
        System.out.println("====================");
        System.out.println("    Aplikacja #2");
        System.out.println("====================");
        
        App app = new App();
        Endpoint.publish(app.url, app);
    }
}