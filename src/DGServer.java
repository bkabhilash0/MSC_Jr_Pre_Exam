import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DGServer {
    public static void main(String[] args) {
        try{
            DatagramSocket ds = new DatagramSocket();
            InetAddress ip = InetAddress.getByName("localhost");

            String message = "Connected";
            DatagramPacket dp = new DatagramPacket(message.getBytes(),message.length(),ip,8080);

            ds.send(dp);
            ds.close();
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
