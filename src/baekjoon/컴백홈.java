package baekjoon;

import java.util.Scanner;

public class 컴백홈 {

    static int R,C,K;
    static String temp;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        K = sc.nextInt();

        map = new int[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++){
            temp = sc.next();
            for(int j=0; j<C; j++){
                if(temp.charAt(j) == '.'){
                    map[i][j] = 0;
                }else{
                    map[i][j] = 1;
                }
            }
        }

        map[0][C-1] = 2;

        answer = 0;

        dfs(R-1,0,1);
        System.out.println(answer);

    }

    public static void dfs(int x, int y, int cnt){

        visited[x][y] = true;

        if(map[x][y] == 2){
            if(cnt == K) answer++;
            return;
        }

        int nx, ny;

        for(int i=0; i<4; i++){
            nx = x+dx[i];
            ny = y+dy[i];

            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

            if(visited[nx][ny]) continue;

            if(map[nx][ny] == 1) continue;

            dfs(nx, ny, cnt+1);
            visited[nx][ny] = false;
        }
    }
}
