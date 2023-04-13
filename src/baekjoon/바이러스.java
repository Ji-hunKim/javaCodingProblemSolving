package baekjoon;

import java.util.Scanner;

public class 바이러스 {
    static int N,K;
    static int[][] inArr;
    static int[][] maps;
    static boolean[] visited;
    static int cnt;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        inArr = new int[K][2];
        maps = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<K; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            inArr[i] = new int[]{a,b};

            maps[a][b] = 1;
            maps[b][a] = 1;
        }

        cnt = 0;
        visited[1] = true;
        dfs(1);

        System.out.println(cnt);
    }
    public static void dfs(int x){
        for(int i=0; i<K; i++){
            if(inArr[i][0] == x){
                int next = inArr[i][1];
                if(!visited[next] && maps[x][next] == 1){
                    visited[next] = true;
                    cnt++;
                    dfs(next);
                }
            }else if(inArr[i][1] == x){
                int next = inArr[i][0];
                if(!visited[next] && maps[x][next] == 1){
                    visited[next] = true;
                    cnt++;
                    dfs(next);
                }
            }
        }
    }
}