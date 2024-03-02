import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Networking {
    public static void main(String[] args) throws Exception {
        URL localhost = new URL("https://www.rajagiri.edu");
        System.out.println(localhost.getProtocol());
        System.out.println(localhost.getHost());
        System.out.println(localhost.getPath());
        System.out.println(localhost.getQuery());
        System.out.println(localhost.getDefaultPort());
        System.out.println(localhost.getRef());

        URLConnection conn = localhost.openConnection();

        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(isr);

        String line = br.readLine();

//        while(line != null){
//            System.out.println(line);
//            line = br.readLine();
//        }

        br.close();
        isr.close();

        InetAddress ip = InetAddress.getByName("www.google.com");
        System.out.println(ip.getHostAddress());
        System.out.println(ip.getHostName());

        byte addr[] = {(byte)142,(byte)250,(byte)196,(byte)68};
        InetAddress ip2 = InetAddress.getByAddress(addr);
        System.out.println(ip2.getHostName());
    }
}
