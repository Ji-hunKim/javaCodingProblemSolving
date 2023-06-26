package baekjoon;

import java.util.Scanner;

public class 적록색약 {
    static int N;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = sc.next();

            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int temp = 0;
        int temp2 = 0;

        char now;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    now = map[i][j];
                    dfs(i,j,now,0);
                    temp++;
                }
            }
        }

        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    now = map[i][j];
                    dfs(i,j,now,1);
                    temp2++;
                }
            }
        }

        System.out.print(temp);
        System.out.print(" ");
        System.out.print(temp2);
    }

    public static void dfs(int x, int y, char color, int flag){
        visited[x][y] = true;
        int nx,ny;
        for(int i=0; i<4; i++){
            nx = x+dx[i];
            ny = y+dy[i];

            if(nx<0 || ny<0 || nx>= N || ny>=N) continue;

            if(visited[nx][ny]) continue;

            if(flag == 0){
                if (map[nx][ny] != color) continue;
            }else{
                if(color == 'R' || color == 'G'){
                    if(map[nx][ny] == 'B') continue;
                }else {
                    if (map[nx][ny] != color) continue;
                }
            }

            dfs(nx,ny,color,flag);
        }
    }

}