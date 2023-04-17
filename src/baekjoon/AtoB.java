package baekjoon;

import java.util.Scanner;

public class AtoB {
    static long A,B;
    static long cnt;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();

        cnt = 1000000000;
        dfs(A, 1);
        if(cnt == 1000000000) cnt = -1;
        System.out.println(cnt);

    }

    public static void dfs(long x, long count){
        if(x==B){
            cnt = Math.min(cnt ,count);
        }else if(x<B){
            dfs(x*2, count+1);
            dfs(x*10+1, count+1);
        }
    }
}
