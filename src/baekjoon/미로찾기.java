package baekjoon;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로찾기 {

    static int N,M;
    static int[][] maps;
    static int[][] value;
    static boolean[][] visited;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        maps = new int[N][M];
        visited = new boolean[N][M];
        value = new int[N][M];

        String temp = "";

        for(int i=0; i<N; i++){
            temp = sc.next();
            for(int j=0; j<M; j++){
                maps[i][j] = temp.charAt(j)-'0';
            }
        }

        bfs();
        System.out.println(value[N-1][M-1]+1);
    }

    public static void bfs(){
        int[] xy = new int[2];
        xy[0] = 0;
        xy[1] = 0;

        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(xy);


        while(!queue.isEmpty()){
            int cur[] = queue.poll();
            int x = cur[0];
            int y = cur[1];

            int curVal = value[x][y];


            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(!visited[nx][ny] && maps[nx][ny] != 0){
                    visited[nx][ny] = true;
                    value[nx][ny] = curVal + 1;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
    }
}