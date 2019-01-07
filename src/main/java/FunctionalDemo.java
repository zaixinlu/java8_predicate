import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.*;

public class FunctionalDemo {

    public void predicate() {
        Predicate<String> namesStartingWithS = name -> name.startsWith("s");
        System.out.println(namesStartingWithS.test("star"));
    }

    public void consumer() {
        Consumer<String> messageConsumer = System.out::println;
        messageConsumer.accept("Learn Java8");
    }

    public void supplier() {
        Supplier<String> uuidGenerator = () -> UUID.randomUUID().toString();
        System.out.println(uuidGenerator.get());
    }

    public void function() {
        Function<String, String> toUpperCase = name -> name.toUpperCase();
        System.out.println(toUpperCase.apply("Java"));
    }



    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 300; i < 400; i++) {
            list.add(i);
        }

        Predicate<Integer> evenNumbers = (i) -> i % 2 == 0;
        evenNumbers.test(1000);

        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 == 1;
        oddNumbers.test(1000);

        Function<Integer, Integer> addOne = x -> x + 1;
        Function<String, String> concat = x -> x + 1;

        Integer two = addOne.apply(1); // yields 2
        String answer = concat.apply("0 + 1 = "); // yields "0 + 1 = 1"

        BinaryOperator<String> sum = (a, b) -> a + b;
        String res = sum.apply("1", "2"); // yields 12

        // composition
        BinaryOperator<Function<Integer, Integer>> compose = (f, g) -> x -> g.apply(f.apply(x));
        Function<Integer, Integer> h = compose.apply(x -> x + 5, y -> 2 * y);
        System.out.println(h.apply(20));

        // partial application
        Function<Integer, UnaryOperator<Integer>> sumX = x -> y -> x + y;
        UnaryOperator<Integer> sum10 = sumX.apply(10);
        System.out.println(sum10.apply(20));

    }
}