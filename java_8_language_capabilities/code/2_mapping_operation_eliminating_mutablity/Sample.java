import java.util.*;
import java.util.function.*;

public class Sample {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    // imperative code
    // lots of mutation like changing the value totalOfValuesDoubled over an over again
    // tell what to do and how to do
    int totalOfValuesDoubled = 0;
    for(int number : numbers) {
      totalOfValuesDoubled += number * 2;
    }

    System.out.println(totalOfValuesDoubled);

    // declartive code
    // only says what to do
    System.out.println(
      numbers.stream()
      .mapToInt(number -> number * 2)
      .sum());
  }
}
