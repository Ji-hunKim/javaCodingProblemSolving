package baekjoon;

import java.io.IOException;
import java.util.*;

public class Main {
    static int[] t;
    static int[] p;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        t = new int[n + 2];
        p = new int[n + 2];
        dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n + 1; i++) {
            max = Math.max(max, dp[i]);

            if (i + t[i] < n + 2 && (max + p[i] > dp[i + t[i]])) {
                dp[i + t[i]] = max + p[i];
            }
        }
        System.out.println(max);

    }
}