package baekjoon;

import java.io.IOException;
import java.util.*;

public class Main {
    static int N;
    static int sum;
    static int[] coins;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);


        N = sc.nextInt();
        sum = sc.nextInt();

        coins = new int[N];

        for(int i=0; i<N; i++){
            coins[i] = sc.nextInt();
        }

        dp = new int[sum+1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for(int i = 0; i < N; i++) {
            for(int j = coins[i]; j <= sum; j++) {
                dp[j] = Math.min(dp[j],dp[j - coins[i]]+1);
            }
        }

        if(dp[sum] == 10001) System.out.println(-1);
        else System.out.println(dp[sum]);

    }
}