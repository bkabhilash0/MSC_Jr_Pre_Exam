interface Human{
    int legs = 4;
    public void walk();
}

interface Animal{
    public void run();
}

public class Sample1 implements Human,Animal{
    public void walk() {
        System.out.println("Walking");
    }

    public void run() {

    }

    public void sleep(){
        System.out.println();
    }

    public static void main(String[] args) {

    }
}
