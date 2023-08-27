package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 탈출 {
    static int R,C;
    static char map[][];
    static Queue<Point> water = new LinkedList<>();
    static int ddx[] = {-1,1,0,0};
    static int ddy[] = {0,0,-1,1};
    static int dx = 0, dy = 0;
    static boolean visited[][];
    static int cnt = 0;
    static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        map = new char[R][C];
        visited = new boolean[R][C];
        int sx = 0, sy = 0;

        for(int i=0; i<R; i++){
            String temp = sc.next();
            for(int j=0; j<C; j++){
                map[i][j] = temp.charAt(j);
                if(map[i][j] == '*'){
                    water.offer(new Point(i,j));
                }else if(map[i][j] == 'S'){
                    sx = i;
                    sy = j;
                }else if(map[i][j] == 'D'){
                    dx = i;
                    dy = j;
                }
            }
        }

        bfs(sx,sy);
        if(!flag) System.out.println("KAKTUS");
        else System.out.println(cnt);
    }

    static void bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(-1,-1));
        queue.offer(new Point(x,y));
        visited[x][y] = true;

        Loop1:
        while(!queue.isEmpty()){
            Point cur = queue.poll();

            if(cur.x == -1){
                cnt++;
                if(!water.isEmpty()){
                    water.offer(new Point(-1,-1));
                    flood();
                }
                if(!queue.isEmpty()){
                    queue.offer(new Point(-1,-1));
                }

                continue;
            }


            for(int i=0; i<4; i++){
                int nx = cur.x + ddx[i];
                int ny = cur.y + ddy[i];

                if(nx<0 || ny<0 || nx>=R || ny>=C) continue;

                if(visited[nx][ny]) continue;

                if(map[nx][ny] == '*' || map[nx][ny] == 'X') continue;

                if(map[nx][ny] == 'D') {
                    flag = true;
                    break Loop1;
                }

                queue.offer(new Point(nx,ny));
                visited[nx][ny] = true;
            }

        }
    }

    static void flood(){
        while(!water.isEmpty()){
            Point cur = water.poll();
            if(cur.x == -1) break;
            for(int i=0; i<4; i++){
                int nx = cur.x + ddx[i];
                int ny = cur.y + ddy[i];

                if(nx<0 || ny<0 || nx>=R || ny>=C) continue;

                if(map[nx][ny] == '.'){
                    map[nx][ny] = '*';
                    water.offer(new Point(nx,ny));
                }
            }
        }
    }

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}