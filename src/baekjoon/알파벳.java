package baekjoon;

import java.util.Scanner;

public class 알파벳 {
    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static boolean[] visited;
    static char[][] map;
    static int R,C;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        String temp;

        map = new char[R][C];
        visited = new boolean[26];
        for(int i=0; i<R; i++){
            temp = sc.next();
            for(int j=0; j<C; j++){
                map[i][j] = temp.charAt(j);
            }
        }

        cnt = 0;

        dfs(0,0, 0);

        System.out.println(cnt);

    }

    public static void dfs(int x, int y, int val) {
        int now = alphabet.indexOf(String.valueOf(map[x][y]));
        if(visited[now]){
            if(val>cnt) cnt = val;
            return;
        }
        visited[now] = true;

        int nx,ny;
        for(int i=0; i<4; i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=R || ny>=C) continue;

            dfs(nx,ny,val+1);
        }
        visited[now] = false;
    }
}