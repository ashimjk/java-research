import java.util.*;

public class Sample2 {

    // This approach leads to duplication, lacks separation of concern.
    public static int totalValues(List<Integer> numbers) {
        int total = 0;
        for (int e : numbers) {
            total += e;
        }
        return total;
    }

    public static int totalEvenValues(List<Integer> numbers) {
        int total = 0;
        for (int e : numbers) {
            if (e % 2 == 0) total += e;
        }
        return total;
    }

    public static int totalOddValues(List<Integer> numbers) {
        int total = 0;
        for (int e : numbers) {
            if (e % 2 != 0) total += e;
        }
        return total;
    }

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);

        // System.out.println(totalValues(values));
        // System.out.println(totalEvenValues(values));
        // System.out.println(totalOddValues(values));

        // This is called strategy pattern
        // you want client to decide strategy rather than defining it
        // Saying I will do the sum but let me know which one to sum
        // so, we are passing the condtion using functional interface
        // condition is passed from outside
        System.out.println(totalValuesUsingPredicate(numbers, e -> true));
        System.out.println(totalValuesUsingPredicate(numbers, e -> e % 2 == 0));
        System.out.println(totalValuesUsingPredicate(numbers, e -> e % 2 != 0));
    }

    // receives functional interface
    public static int totalValuesUsingPredicate(List<Integer> numbers,
        Predicate<Integer> selector) {

            return numbers.stream()
                            .filter(selector)
                            .reduce(0, (c, e) -> c + e);

        // int total = 0;
        // for (int e : numbers) {
        //     if (selector.test(e)) total += e;
        // }
        // return total;
    }
}