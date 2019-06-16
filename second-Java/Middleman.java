import javax.jws.WebMethod;
import javax.jws.WebService;
//import javax.jws.WebParam;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

@WebService
public class Middleman {
    // zmienne predefiniowane
    int port = 12345;
    String inputIp = "127.0.0.1"; 
    String outputIp = "127.0.0.1";

    public Middleman() {
    };

    @WebMethod(operationName = "sendOver") 
    public void sendOver(String data){
        // TODO: wez dane i wyrzuć na socket/UDP
        System.out.println(data);
    }

    void run() {
        ServiceService helloService = new ServiceService();
		Service hello = helloService.getServicePort();
		System.out.println(hello.getTime("mkyong"));
    }

    // private void startSendingData() throws IOException {
    //     String data;
    //     DatagramSocket socket = new DatagramSocket();

    //     while ((data = bufferedReader.readLine()) != null) {
    //         // data = data.concat("\n");
    //         byte[] byteData = data.getBytes();
    //         DatagramPacket dp = new DatagramPacket(byteData, byteData.length, host, port);
    //         socket.send(dp);
    //     }
    //     socket.close();
    // }

    public static void main(String args[]) {
        Middleman middleman = new Middleman();
        middleman.run();
    }
}