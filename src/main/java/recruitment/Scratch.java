package recruitment;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.MINUTES;

class Scratch {
    public static void main(String[] args) {
        System.out.println(Duration.of(5, MINUTES).toString());
    }
}