package recruitment;

import org.apache.commons.lang3.StringUtils;

import java.util.Map;
import java.util.TreeMap;

public class RecDataProcessingSolved {

    public static void main(String[] args) {

        Map<Integer, String> ageToName = new TreeMap<>();
        ageToName.put(13, "Adam");
        ageToName.put(12, "John");
        ageToName.put(1, "anna");
        ageToName.put(6, "jack");
        ageToName.put(4, "Kate");
        ageToName.put(23, null);


        //print youngest person having name starting with 'J'
        ageToName.values().stream()
                .filter(s -> StringUtils.startsWithIgnoreCase(s, "J"))
                .findFirst()
                .ifPresent(System.out::println);
    }
}

