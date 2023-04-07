package baekjoon;

import java.io.IOException;
import java.util.*;
public class 전쟁전투 {
    static int N,M;
    static char[][] map;
    static boolean[][] visited;
    static int[] xx = {0,0,1,-1};
    static int[] yy = {1,-1,0,0};
    static int wVal = 0;
    static int bVal = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new char[M][N];
        visited = new boolean[M][N];

        for(int i=0; i<M; i++){
            String temp  = sc.next();
            for(int j=0; j<N; j++){
                map[i][j] = temp.charAt(j);
            }
        }

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && map[i][j] == 'W'){
                    dfs(i,j,'W');
                }else if(!visited[i][j] && map[i][j] == 'B'){
                    dfs(i,j,'B');
                }
                if(map[i][j] == 'W') wVal += cnt*cnt;
                else bVal += cnt*cnt;
                cnt = 0;
            }
        }

        System.out.print(wVal + " " + bVal);

    }

    public static void dfs(int x, int y, char color) {
        visited[x][y] = true;
        cnt++;

        for(int i=0; i<4; i++){
            int ix = x + xx[i];
            int iy = y + yy[i];

            if(ix >= 0 && ix < M && iy >= 0 && iy<N && !visited[ix][iy] && map[ix][iy] == color){
                dfs(ix,iy,color);
            }
        }
    }
}