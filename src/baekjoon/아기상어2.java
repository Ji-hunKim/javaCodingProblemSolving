package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 아기상어2 {
    static int n,m;
    static int xpos[]= {0,0,1,-1,1,1,-1,-1};
    static int ypos[]= {1,-1,0,0,1,-1,-1,1};
    static int[][] map;
    static int[][] dis;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        n=sc.nextInt();
        m=sc.nextInt();

        map=new int[n][m];
        dis=new int[n][m];

        Queue<Shark> q=new LinkedList<Shark>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j]=sc.nextInt();
                if(map[i][j]==1) {
                    q.add(
                            new Shark(i,j));
                }
            }
        }
        int answer=Integer.MIN_VALUE;

        while(q.size()!=0) {
            Shark cur = q.poll();

            int x = cur.x;
            int y = cur.y;

            for (int j = 0; j < 8; j++) {
                int nx = x + xpos[j];
                int ny = y + ypos[j];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m)continue;

                // 방문기록 있거나 상어인 경우 continue
                if(dis[nx][ny] != 0 || map[nx][ny] == 1) continue;

                dis[nx][ny] = dis[x][y] + 1;

                if(dis[nx][ny] > answer) answer = dis[nx][ny];

                q.add(new Shark(nx,ny));
            }
        }
        System.out.println(answer);
    }
    class Shark{
        int x;
        int y;
        public Shark(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
}