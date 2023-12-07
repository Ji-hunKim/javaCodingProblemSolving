package programmerss;

import java.util.*;

class 무인도여행 {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int N,M;
    static int cnt;

    public int[] solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();

        map = new int[N][M];
        visited = new boolean[N][M];

        String[] temp;
        for(int i=0; i<N; i++){
            temp = maps[i].split("");
            for(int j=0; j<M; j++){
                if(temp[j].equals("X")){
                    map[i][j] = 0;
                }else{
                    map[i][j] = Integer.parseInt(temp[j]);
                }
            }
        }

        List<Integer> li = new ArrayList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != 0 && !visited[i][j]){
                    cnt = 0;
                    dfs(i,j);
                    li.add(cnt);
                }
            }
        }

        Collections.sort(li);
        int[] answer;

        if(li.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
        }else{
            answer = new int[li.size()];
            for(int i=0; i<li.size(); i++){
                answer[i] = li.get(i);
            }
        }

        return answer;
    }

    public void dfs(int x, int y){
        visited[x][y] = true;
        cnt += map[x][y];

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;

            if(visited[nx][ny]) continue;

            if(map[nx][ny] == 0) continue;

            dfs(nx,ny);
        }
    }
}