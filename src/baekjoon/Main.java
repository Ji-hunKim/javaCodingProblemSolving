package baekjoon;

import java.util.*;

public class Main {
    static int F,S,G,U,D,cnt;
    static boolean[] visited;
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        cnt = -1;

        visited = new boolean[F + U + D];
        flag = false;
        bfs(S);

        if(flag) System.out.println("use the stairs");
        else System.out.println(cnt);

    }

    static void bfs(int now) {

        while(true){
            visited[now] = true;
            cnt++;

            if(now == G){
                break;
            }

            if(now <= G + D) now = now + U;
            else now = now - D;

            if(now <= 0) continue;
            if(visited[now]) {
                flag = true;
                break;
            }
        }


    }

}