import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            Socket socket = new Socket("localhost",8080);

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String message = dis.readUTF();
            System.out.println("Server: "+message);

            while(!message.equalsIgnoreCase("bye")){
                System.out.println("Client: Enter a Message: ");
                String tmp = sc.nextLine();
                dos.writeUTF(tmp);
                message = dis.readUTF();
                System.out.println("Server: "+message);
            }

            dos.close();
            dis.close();
            socket.close();
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
