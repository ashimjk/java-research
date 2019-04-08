import java.util.*;
import java.util.function.*;

public class Sample {
  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    // Its familiar but not simple
    // external iterator
    // for(int i = 0; i < numbers.size(); i++) {
      // System.out.println(i);
    // }

    // simple
    // external iterator (manage by ourself)
    // how to do and what to do
    // for(int e : numbers) {
    //   System.out.println(e);
    // }

    // internal iterator
    // only what to do
    // executing forEach can be sequential, concurrent or lazy
    // numbers.forEach(new Consumer<Integer>() {
    //   public void accept(Integer number) {
    //     System.out.println(number);
    //   }
    // });

    // internal iterator
    // only what to do
    // ceremony is what you have to do before you get to do
    // before what you really want to do
    // Function has a name, parameter, body and return type 
    // numbers.forEach((Integer number) -> System.out.println(number));

    // internal iterator
    // only what to do
    // numbers.forEach(number -> System.out.println(number));

    // internal iterator
    // only what to do
    numbers.forEach(System.out::println);
  }
}
