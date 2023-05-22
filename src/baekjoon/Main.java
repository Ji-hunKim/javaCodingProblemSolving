package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int T;
    static int n,m;
    static int K;

    static int[][] map;
    static boolean[][] visited;
    static int baechoo;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int t=0; t<T; t++){
            answer = 0;

            m = sc.nextInt();
            n = sc.nextInt();
            baechoo = sc.nextInt();

            map = new int[n][m];
            visited = new boolean[n][m];

            int first,two;
            for(int b=0; b<baechoo; b++){
                two = sc.nextInt();
                first = sc.nextInt();
                map[first][two] = 1;
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j] == 1 && !visited[i][j]){
                        dfs(i,j);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }


    }

    public static void dfs(int x, int y){
        visited[x][y] = true;

        int nx;
        int ny;

        for(int i=0; i<4; i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            if(map[nx][ny] == 0 || visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny);
        }
    }

}