import java.io.FileOutputStream;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Engine implements Serializable{
    String model;
    String type;
    double capacity;

    Engine(String model,String type,double capacity){
        this.model = model;
        this.type = type;
        this.capacity = capacity;
    }
}

public class Vehicle implements Serializable {
    int wheels = 4;
    Engine engine;

    public Vehicle(int wheels, Engine engine) {
        this.wheels = wheels;
        this.engine = engine;
    }

    public static void main(String[] args) {
//        Engine eng = new Engine("ABC","Petrol",50);
//        Vehicle bmw = new Vehicle(4,eng);

        Vehicle bmw = new Vehicle(4,new Engine("ABC","Petrol",50));

        try{
            FileOutputStream fos = new FileOutputStream("bmw.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(bmw);
            System.out.println("Serialization Success");
        }catch(NotSerializableException ne){
            System.out.println(ne.getMessage());
            System.out.println("Not Serializable");
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }
}
