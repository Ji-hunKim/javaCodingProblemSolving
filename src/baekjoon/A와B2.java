package baekjoon;

import java.util.Scanner;

public class A와B2 {

    static int K;
    static String S, T;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.next();
        T = sc.next();
        K = T.length();
        dfs(T);
        System.out.println(result);
    }

    public static void dfs(String t) {
        if (S.length() == t.length()) {
            if (S.equals(t)) {
                result = 1;
            }
            return;
        }
        if (t.charAt(0) == 'B') {
            String substring = t.substring(1);
            StringBuilder sb = new StringBuilder(substring);
            String string = sb.reverse().toString();
            dfs(string);
        }

        if (t.charAt(t.length() - 1) == 'A') {
            dfs(t.substring(0, t.length() - 1));
        }
    }
}