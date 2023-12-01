package programmerss;

import java.util.*;

class 리코쳇로봇 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int N,M;
    static int cnt = Integer.MAX_VALUE;

    public int solution(String[] board) {
        int sx = 0;
        int sy = 0;
        N = board.length;
        M = board[0].length();

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String[] sp = board[i].split("");
            for(int j=0; j<M; j++){
                String now = sp[j];
                int val = 0;
                if(now.equals(".")) map[i][j] = 0;
                else if(now.equals("D")) map[i][j] = 1;
                else if(now.equals("G")) map[i][j] = 2;
                else {
                    map[i][j] = 0;
                    sx = i;
                    sy = j;
                }
            }
        }

        bfs(sx,sy);

        if(cnt == Integer.MAX_VALUE) cnt = -1;

        return cnt;
    }

    public void bfs(int x,int y){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x,y,0));

        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(visited[cur.x][cur.y]) continue;
            if(map[cur.x][cur.y] == 2){
                cnt = Math.min(cnt, cur.tmp);
                continue;
            }
            visited[cur.x][cur.y] = true;

            for(int i=0; i<4; i++){

                // 0:오른쪽
                if(i == 0){
                    for(int j=cur.y+1; j<M; j++){
                        if(map[cur.x][j] == 1) {
                            queue.offer(new Node(cur.x,j-1,cur.tmp+1));
                            break;
                        }
                        if(j == M-1){
                            queue.offer(new Node(cur.x,j,cur.tmp+1));
                        }
                    }
                }

                // 1:왼쪽
                else if(i == 1){
                    for(int j=cur.y-1; j>=0; j--){
                        if(map[cur.x][j] == 1) {
                            queue.offer(new Node(cur.x,j+1,cur.tmp+1));
                            break;
                        }
                        if(j == 0){
                            queue.offer(new Node(cur.x,j,cur.tmp+1));
                        }
                    }
                }

                // 2:아래쪽
                else if(i == 2){
                    for(int j=cur.x+1; j<N; j++){
                        if(map[j][cur.y] == 1) {
                            queue.offer(new Node(j-1,cur.y,cur.tmp+1));
                            break;
                        }
                        if(j == N-1){
                            queue.offer(new Node(j,cur.y,cur.tmp+1));
                        }
                    }
                }

                // 3:위쪽
                else if(i == 3){
                    for(int j=cur.x-1; j>=0; j--){
                        if(map[j][cur.y] == 1) {
                            queue.offer(new Node(j+1,cur.y,cur.tmp+1));
                            break;
                        }
                        if(j == 0){
                            queue.offer(new Node(j,cur.y,cur.tmp+1));
                        }
                    }
                }
            }
        }
    }
}

class Node {
    int x;
    int y;
    int tmp;

    public Node(int x,int y,int tmp){
        this.x = x;
        this.y = y;
        this.tmp = tmp;
    }
}