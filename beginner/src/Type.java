import java.util.ArrayList;
import java.util.function.BiFunction;

public class Type {
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        ArrayList<String> arr2 = new ArrayList<String>();
        while (arr.size() < 10) {
            arr.add(arr.size() + 1);
        };

        while (arr2.size() < 10) {
            arr2.add("hello");
        };

        int sum = reduce(arr, 0, (acc, el) -> acc + el);
        String sum2 = reduce(arr2, "", (acc, el) -> acc + el);

        System.out.println(sum);
        System.out.println(sum2);


    }

    static void FizzBuzz(int n) {
        for (int i = 1; i < n; i++){
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }
    }


    static <T> T reduce(ArrayList<T> array, T initialValue, BiFunction<T, T, T> fn) {
        T accumulator = initialValue;
        for (T current : array) {
            accumulator = fn.apply(accumulator, current);
        }
        return accumulator;
    }
}
