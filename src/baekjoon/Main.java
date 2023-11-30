package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int N;
    static int[] dx = {0,1,1};
    static int[] dy = {1,1,0};
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            String[] str = bf.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        dfs(0,1);

        System.out.println(cnt);
    }

    public static void dfs(int i, int j){
        if(i == N-1 && j == N-1) {
            cnt++;
            return;
        }

        for(int k=0; k<3; k++){
            if(k == 0 || k == 2){
                int nx = i+dx[k];
                int ny = j+dy[k];

                if(nx<0 || ny<0 || nx>=N || ny>=N) continue;

                if(map[nx][ny] == 1) continue;
                dfs(nx,ny);
            }else{
                boolean flag = false;

                for(int p=0; p<3; p++){
                    int nx = i+dx[p];
                    int ny = j+dy[p];

                    if(nx<0 || ny<0 || nx>=N || ny>=N) {
                        flag = true;
                        break;
                    }

                    if(map[nx][ny] == 1) {
                        flag = true;
                        break;
                    }
                }

                if(flag) continue;

                int nx = i+dx[k];
                int ny = i+dy[k];

                dfs(nx,ny);
            }

        }

    }

}
