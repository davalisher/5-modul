package uz.pdp;

public class Main {
    static int x=5;
    int y=10;
    public static void main(String[] args) {
        int a=15;

        MyInterfaceImpl myInterfaceByConcreteClass = new MyInterfaceImpl();
        System.out.println("myInterfaceByConcreteClass.test(5) = " + myInterfaceByConcreteClass.test(5));
        MyInterface<Integer> myInterfaceByAnonymClass = new MyInterface<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return (integer & 1) == 0;
            }
        };
        System.out.println("myInterfaceByAnonymClass.test(5) = " + myInterfaceByAnonymClass.test(5));

        MyInterface<Integer> myInterfaceByLambda = integer -> (integer & 1) == 0;
        MyInterface<String> myInterfaceString = s -> s.contains("Hello");
        System.out.println("myInterfaceString.test(\"Hello Java\") = " + myInterfaceString.test("Hello Java"));
        MyInterface<Integer> myInterfaceInteger = integer -> {
            integer+=x;
            integer+=new Main().y;
//            a+=x
            integer+=a;
           return Math.pow(integer, 3) > 100;
        };
//        a*=a;
        System.out.println("myInterfaceInteger.test(5) = " + myInterfaceInteger.test(5));
    }

}

interface MyInterface<T> {
    //        abstract, default, static
    boolean test(T t);
}

class MyInterfaceImpl implements MyInterface<Integer> {
    @Override
    public boolean test(Integer integer) {
        return (integer & 1) == 0;
    }
}
