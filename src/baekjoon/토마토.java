package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 토마토 {

    static int N,M;
    static int[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int maxVal = -1;
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        M = scan.nextInt();
        N = scan.nextInt();

        map = new int[N][M];

        Queue<Node> queue = new LinkedList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = scan.nextInt();
                if(map[i][j] == 1){
                    queue.offer(new Node(i,j));
                }else if(map[i][j] == 0){
                    flag = true;
                }
            }
        }

        if(!flag) maxVal = 1;
        else{
            while(!queue.isEmpty()){
                Node current = queue.poll();

                for(int i=0; i<4; i++){
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];

                    if(nx<0 || ny<0 || nx>=N || ny>=M) continue;

                    if(map[nx][ny] != 0) continue;

                    map[nx][ny] = map[current.x][current.y] + 1;
                    queue.offer(new Node(nx,ny));
                }
            }

            Loop1:
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j] == 0){
                        maxVal = 0;
                        break Loop1;
                    }
                    maxVal = Math.max(map[i][j], maxVal);
                }
            }
        }
        System.out.println(maxVal-1);
    }


    public static class Node {
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
