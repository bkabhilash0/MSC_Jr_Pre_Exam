import java.io.*;

public class Person implements Serializable {
    String name;
    int age;
    transient String password = "sample123";

    Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    void printInfo(){
        System.out.println("My name is "+this.name);
        System.out.println("My age is "+this.age);
    }

    private void printPassword(){
        System.out.println("Password is "+this.password);
    }

    public static void main(String[] args) {
        Person p1 = new Person("Abhilash",23);
//        for(int i = 0; i < 10; i++) {
//            try {
//                if (i == 5) {
//                    throw new Exception("Invalid Input");
//                }
//                System.out.println(i);
//            } catch (Exception e) {
//                System.out.println("Invalid");
//            }finally {
//                System.out.println("Finally");
//            }
//        }

        try {
            FileOutputStream fout = new FileOutputStream("abhilash.txt");
            ObjectOutputStream oout = new ObjectOutputStream(fout);

            oout.writeObject(p1);

            oout.close();
            fout.close();

            System.out.println("Serialization Successful");

            FileInputStream fin = new FileInputStream("abhilash.txt");
            ObjectInputStream oin = new ObjectInputStream(fin);

            Person p2 = (Person) oin.readObject();
            System.out.println(p2.password);
            p2.printPassword();

            p2.printInfo();
        }catch(Exception e){
            System.out.println("Error Occured!");
        }
    }
}
