import java.util.*;

public class Sample {

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);

    // double the first even number greater than 3 from the list
    // the code is broken here because there are lot of things that you have to know first
    // 1. what is this code for
    // 2. what it is trying to accomplish
    // 3. little  room for change
    // imperative code
    // mutability
    // low level construct
    int result = 0;
    for (int e : numbers) {
        if (e > 3 && e % 2 == 0) {
            result = e * 2;
            break;
        }
    }

    System.out.println(result);

    System.out.println("==============================");

    // the code is revealing
    // declarative code
    // findFirst returns the optional
    // stream may not have any even number
    // handles null pointer exception
    // provides the substitute values
    System.out.println(
        numbers.stream()
                .filter(e -> e > 3)
                .filter(e -> e % 2 == 0)
                .map(e -> e * 2)
                .findFirst()
                .orElse(0 )
    );

  }
}

