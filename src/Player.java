import java.io.*;

class Base implements Serializable {
    String name = "Abhilash";
    int age = 23;
}

public class Player extends Base{
    int score = 100;

    public static void main(String[] args) {
        Player p1 = new Player();

        try{
            FileOutputStream fos = new FileOutputStream("player.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(p1);
            System.out.println("Serialization Successful!");

            FileInputStream fis = new FileInputStream("player.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Player p2 = (Player) ois.readObject();
            System.out.println(p2.score);
            System.out.println(p2.name);
            System.out.println(p2.age);


        }catch(Exception e){

        }
    }
}
