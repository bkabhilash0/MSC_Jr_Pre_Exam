import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DGClient {
    public static void main(String[] args) {
        try{
            DatagramSocket ds = new DatagramSocket(8080);
            byte[] data = new byte[1024];

            DatagramPacket dp = new DatagramPacket(data,1024);

            ds.receive(dp);

            String message = new String(dp.getData(),0,dp.getLength());
            System.out.println(message);

            ds.close();
        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
