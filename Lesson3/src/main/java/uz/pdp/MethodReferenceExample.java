package uz.pdp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MethodReferenceExample {
    public static void main(String[] args) {
        YourInterface maxOf1 = (x, y) -> x > y ? x : y;
        YourInterface maxOf2 = Math::max;
        var obj=new MethodReferenceExample();
        YourInterface powOf1=obj::pow;
        System.out.println("maxOf.get(5,6) = " + maxOf1.get(5, 6));
        System.out.println("maxOf2.get(5,6) = " + maxOf2.get(5, 6));
        List<Integer> integers=new ArrayList<>();
        integers.forEach(System.out::println);

    }

    int pow(int num, int degree){
        int res=1;
        for (int i = 0; i < degree; i++) {
            res*=num;
        }
        return res;
    }
}

@FunctionalInterface
interface YourInterface {
    int get(int a, int b);

}