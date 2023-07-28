package uz.pdp;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.*;

public class FunctionalInterfacesExamples {
    static Random random = new Random();

    public static void main(String[] args) {
        Predicate<Integer> predicate = integer -> (integer & 1) == 0;
        var numbers = new ArrayList<Integer>();
        Supplier<Integer> supplier = () -> random.nextInt(10,20);
        for (int i = 0; i < 10; i++) {
            numbers.add(supplier.get());
        }
        System.out.println("numbers = " + numbers);
        numbers.removeIf(predicate);
//        numbers.removeIf(integer -> (integer&1)==0);
        System.out.println("numbers after removeIf= " + numbers);
        Consumer<Integer> consumer = System.out::println;
        numbers.forEach(consumer);
//        numbers.forEach(System.out::println);

        Function<String, Integer> stringToIntConvertor= Integer::valueOf;
        System.out.println("stringToIntConvertor.apply(\"45\")+65 = " + (stringToIntConvertor.apply("45") + 65));
        UnaryOperator<Double> root= Math::sqrt;
        BiFunction<String, Integer, StudentBirthYearDTO> function= StudentBirthYearDTO::new;
//        BiFunction<String, Integer, StudentBirthYearDTO> function= (fullName, birthYear) -> new StudentBirthYearDTO(fullName,birthYear);
        BinaryOperator<Double> binaryOperator= Math::pow;
//        BinaryOperator<Double> binaryOperator=(num, degree) -> Math.pow(num,degree);


    }
}
