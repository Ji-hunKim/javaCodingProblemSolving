package baekjoon;

import java.util.*;

public class Main {

    static int N,L,R,cnt,answer;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,1};
    static int[] dy = {1,0};
    static List<Integer> li = new ArrayList<>();



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        map = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }
        answer = 0;
        bfs();
        System.out.println(answer);
    }

    private static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0,0, false));

        while(true){
            cnt = 0;
            visited = new boolean[N][N];

            while(!queue.isEmpty()){
                Node now = queue.poll();
                int ix = now.x;
                int iy = now.y;

                visited[ix][iy] = true;

                for(int i=0; i<2; i++){
                    int nx = ix + dx[i];
                    int ny = iy + dy[i];

                    if(nx >= N || ny >= N) continue;

                    if(visited[nx][ny]) continue;

                    if(Math.abs(map[ix][iy] - map[nx][ny]) >= L && Math.abs(map[ix][iy] - map[nx][ny]) <= R){
                        if(!now.ch){
                            li.add(map[ix][iy]);
                            li.add(map[nx][ny]);
                            cnt += 2;
                        }else{
                            li.add(map[nx][ny]);
                            cnt++;
                        }
                        queue.offer(new Node(nx,ny,true));
                    }else{
                        queue.offer(new Node(nx,ny,false));
                    }
                }
            }
            if(cnt == 0) return;

            int sum = 0;
            int val = 0;

            for(int i=0; i<li.size(); i++){
                sum += li.get(i);
            }

            val = sum / cnt;

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(visited[i][j]){
                        map[i][j] = val;
                    }
                }
            }
            answer++;
            li.clear();
        }
    }

    private static class Node{
        int x;
        int y;
        boolean ch;

        public Node(int x, int y, boolean ch) {
            this.x = x;
            this.y = y;
            this.ch = ch;
        }
    }


}
