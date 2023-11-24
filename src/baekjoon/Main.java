package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0,};
    static int room;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String[] str = bf.readLine().split("");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        List<Integer> li = new ArrayList<>();
        int cnt = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && map[i][j] != 0){
                    room = 0;
                    dfs(i,j);
                    cnt++;
                    li.add(room);
                }
            }
        }

        Collections.sort(li);
        System.out.println(cnt);
        for(int i=0; i<li.size(); i++){
            System.out.println(li.get(i));
        }
    }

    public static void dfs(int i, int j){
        visited[i][j] = true;
        room++;

        for(int k=0; k<4; k++){
            int nx = i+dx[k];
            int ny = j+dy[k];

            if(nx<0 || ny<0 || nx>=N || ny>=N) continue;

            if(visited[nx][ny]) continue;

            if(map[nx][ny] == 0) continue;

            dfs(nx,ny);
        }

    }

}
