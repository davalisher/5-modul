package uz.pdp;

public class LambdaWithLocalVariable {
        static int[] nums={1,2,3,4,5,6,7,8,9};
    public static void main(String[] args) {
        ItsInterface itsInterface=num -> (num&1)==0;
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            final int a=i;
            if (check(nums[i], num -> ((num*a)&1)==0)){
                res+=nums[i];
            }
        }


    }
    static boolean check(int num,ItsInterface itsInterface){

        return (itsInterface.isEqual(6));
    }


}
interface ItsInterface{
    boolean isEqual(int num);
};
