import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            ServerSocket ss = new ServerSocket(8080);
            Socket s = ss.accept();

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            dos.writeUTF("You are connected to the Server");

            String message = dis.readUTF();
            System.out.println("Client: "+message);

            while(!message.equalsIgnoreCase("bye")){
                message = dis.readUTF();
                System.out.println("Client: "+message);
                sc.next();
                System.out.println("Server: Enter a Message: ");
                sc.next();
                String tmp = sc.nextLine();
                dos.writeUTF(tmp);
            }

            dos.close();
            dis.close();
            s.close();
            ss.close();
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
