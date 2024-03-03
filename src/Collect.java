import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Collect {
    public static void main(String[] args) {
//        int[] ar = new int[10];
        ArrayList arr = new ArrayList();
        arr.add(5);
        arr.add(3);
        arr.add(7);

        arr.remove(2);

        LinkedList ll = new LinkedList();
        ll.add(3);

        for(int i=0; i <arr.size();i++){
            System.out.println(arr.get(i));
        }

        HashSet myset = new HashSet();
        myset.add(5);
        myset.add(10);
        myset.add(15);
        myset.add(10);

        System.out.println(myset);

        HashMap map = new HashMap();
        map.put("name","Abhilash");
        map.put("age","23");

        System.out.println(map);
    }

}
