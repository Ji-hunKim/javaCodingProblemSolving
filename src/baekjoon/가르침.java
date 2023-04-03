package baekjoon;

import java.util.Scanner;

public class 가르침 {
    static int N,K;
    static int max = 0;
    static boolean visit[] = new boolean[26];
    static String[] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        K = scanner.nextInt();

        arr = new String[N];

        if(K<5) {
            System.out.println(0);
            return;
        }else if(K==26) {
            System.out.println(N);
            return;
        }else {
            for (int i = 0; i < N; i++) {
                String str = scanner.next();
                arr[i] = str.substring(4, str.length() - 4);
            }
            K -= 5;
            visit['a' - 97] = true;
            visit['n' - 97] = true;
            visit['t' - 97] = true;
            visit['i' - 97] = true;
            visit['c' - 97] = true;
            dfs(0, 0);
            System.out.println(max);
        }
    }

    private static void dfs(int start, int count) {
        if(count == K) {
            int rs = 0;
            for(int i=0; i<N; i++) {
                boolean isTrue = true;
                for(int j=0; j<arr[i].length(); j++) {
                    if(!visit[arr[i].charAt(j)-97]) {
                        isTrue = false;
                        break;
                    }
                }
                if(isTrue) {
                    rs++;
                }
            }
            max = Math.max(max, rs);
            return;
        }

        for(int i=start; i<26; i++) {
            if(!visit[i]) {
                visit[i]=true;
                dfs(i, count+1);
                visit[i]=false;
            }
        }
    }
}