package baekjoon;

import java.io.IOException;
import java.util.*;

public class 단지번호붙이기 {
    static int N;
    static int[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean visited[][];
    static int temp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new int[N][N];

        for(int i=0; i<N; i++){
            String str = sc.next();
            String[] strArr = str.split("");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(strArr[j]);
            }
        }

        visited = new boolean[N][N];

        int answer = 0;
        List<Integer> cntList = new ArrayList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    answer++;
                    temp = 0;
                    bfs(i,j);
                    cntList.add(temp);
                }
            }
        }
        System.out.println(answer);

        Collections.sort(cntList);

        for(int i=0; i<cntList.size(); i++){
            System.out.println(cntList.get(i));
        }

    }
    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            temp++;
            int []cur = queue.poll();

            int a = cur[0];
            int b = cur[1];


            for(int i=0; i<4; i++){
                int nx = a + dx[i];
                int ny = b + dy[i];

                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]){
                    if(map[nx][ny] == 1){
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }

    }

    public static void dfs(int x, int y){
        visited[x][y] = true;
        temp++;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]){
                if(map[nx][ny] == 1){
                    dfs(nx, ny);
                }
            }
        }
    }
}