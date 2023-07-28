package uz.pdp;

import java.util.Arrays;

public class LambdaAsParameter {

        static int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static void main(String[] args) {

        Expression min = (nums) -> {
            Arrays.sort(nums);
            return nums[0];
        };
        Expression max = (nums) -> {
            Arrays.sort(nums);
            return nums[nums.length - 1];
        };
        Expression first =n -> n[0];
        test(max);
        test(min);
        test(first);

    }

    private static void test(Expression func) {
        System.out.println("func.getX(numbers) = " + func.getX(numbers));

    }
}

interface Expression {
    int getX(int[] n);
}
