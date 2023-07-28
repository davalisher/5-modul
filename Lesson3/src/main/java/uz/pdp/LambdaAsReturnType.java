package uz.pdp;

@FunctionalInterface
interface ArrayProcessor {
    double apply( double[] array );
}

public class LambdaAsReturnType {

    public static void main(String[] args) {
        double[] firstList = { 1, 2, 3, 4, 5, 6, 4, 8, 9, 10 };
        System.out.println(counter(4).apply(firstList) );
    }

    public static ArrayProcessor counter( double value ) {
        return array -> {
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == value)
                    count++;
            }
            return count;
        };
    }
 }