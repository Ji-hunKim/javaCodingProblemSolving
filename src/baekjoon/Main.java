package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


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

        dp = new int[sum+1];
        dp[0] = 1;

        for(int i = 0; i < N; i++) {
            for(int j = coins[i]; j <= sum; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        System.out.println(dp[sum]);

    }
}



public class Main {
    static int N;
    static int[] num;
    static int maxVal = -Integer.MAX_VALUE;
    static int minVal = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer stk = new StringTokenizer(bf.readLine(), " ");

        num = new int[N];
        int[] calc = new int[4];

        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(stk.nextToken());
        }

        stk = new StringTokenizer(bf.readLine(), " ");

        for(int i=0; i<4; i++){
            calc[i] = Integer.parseInt(stk.nextToken());
        }


        calculator(1, num[0], calc);

        System.out.println(maxVal);
        System.out.println(minVal);
    }

    public static void calculator(int k, int total, int[] arr){
        if(k == N){
            maxVal = Math.max(maxVal, total);
            minVal = Math.min(minVal, total);
            return;
        }

        // +
        if(arr[0] > 0){
            arr[0] -= 1;
            calculator(k+1, total + num[k], arr);
            arr[0] += 1;
        }

        // -
        if(arr[1] > 0){
            arr[1] -= 1;
            calculator(k+1, total - num[k], arr);
            arr[1] += 1;
        }

        // *
        if(arr[2] > 0){
            arr[2] -= 1;
            calculator(k+1, total * num[k], arr);
            arr[2] += 1;
        }

        // /
        if(arr[3] > 0){
            arr[3] -= 1;
            calculator(k+1, total / num[k], arr);
            arr[3] += 1;
        }

    }
}
