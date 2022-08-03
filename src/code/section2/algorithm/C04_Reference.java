package code.section2.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C04_Reference {
    static int n,k;
    static int coin[];
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] t = br.readLine().split(" ");
        n = Integer.parseInt(t[0]);
        k = Integer.parseInt(t[1]);
        coin = new int[n];
        dp = new int[k+1];
        for(int i=0; i<n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        dp[0]=1;

        for(int i=0; i<n; i++) {
            for(int j=coin[i]; j<=k; j++) {
                dp[j] += dp[j-coin[i]];

            }
        }
        for(int i=1; i<=k; i++) {
            System.out.println(dp[i]);
        }
        System.out.println(dp[k]);
    }

}
