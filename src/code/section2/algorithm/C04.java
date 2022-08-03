package code.section2.algorithm;

public class C04 {
    public static void main(String[] args) {
//        int output = ocean(50, new int[]{10, 20, 50});
//        System.out.println(output); // 4

        long output = ocean(50, new int[]{10, 20, 50});
        System.out.println(output); // 10

//        int output = ocean(30, new int[]{5, 6, 7});
//        System.out.println(output); // 4
    }
    public static long ocean(int target, int[] type) {
        // TODO:

        long[] dp = new long[target+1];

        dp[0]=1;

        for(int i=0; i<type.length; i++) {
            System.out.println("j = " + type[i]);
            for(int j=type[i]; j<=target; j++) {
                dp[j] += dp[j-type[i]];
            }
        }

        return (long)dp[target];
    }
}
