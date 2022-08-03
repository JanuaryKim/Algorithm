package code;

public class JustPractice4 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,4,8,20,10};

        System.out.println(checkPreSum(arr));
    }

    public static boolean checkPreSum(int[] arr) {

        int preSum = 0;

        for (int i : arr) {
            if(i <= preSum) return false;
            else preSum += i;
        }
        return true;
    }
}
