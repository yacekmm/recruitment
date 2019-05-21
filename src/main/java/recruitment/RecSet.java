package recruitment;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

class RecSet {

    public static void main(String[] args) {

        Set<Item> set = new HashSet<>();

        IntStream
                .range(0, 10)
                .forEach(i -> set.add(new Item("value")));

        //what will be printed?
        System.out.println("Set size is: " + set.size());
    }


    static class Item {
        private String key;

        public Item(String key) {
            this.key = key;
        }
    }
}