package recruitment;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RecDataProcessing {

    public static void main(String[] args) {

        Map<Integer, String> ageToName = new TreeMap<>();
        ageToName.put(13, "Adam");
        ageToName.put(12, "John");
        ageToName.put(1, "anna");
        ageToName.put(6, "jack");
        ageToName.put(4, "Kate");


        //print persons having name starting with'J'
        ageToName.entrySet().stream().filter( a -> a.getValue().startsWith("j")).collect(Collectors.toList());
        System.out.println("hello");

        //print youngest person


    }
}

