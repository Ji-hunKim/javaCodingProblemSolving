package baekjoon;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS와BFS {

    //함수에서 사용할 변수들
    static int[][] link; //간선 연결상태
    static boolean[] visited; //확인 여부
    static int V; //정점개수
    static int E; //간선개수
    static int start; //시작정점

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        start = sc.nextInt();

        link = new int[1001][1001]; //좌표를 그대로 받아들이기 위해 +1해서 선언
        visited = new boolean[1001]; //초기값 False

        //간선 연결상태 저장
        for(int i = 0; i < E; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            link[x][y] = link[y][x] = 1;
        }

        dfs(start); //dfs호출

        visited = new boolean[1001]; //확인상태 초기화
        System.out.println(); //줄바꿈

        bfs(); //bfs호출
    }

    //시작점을 변수로 받아 확인, 출력 후 다음 연결점을 찾아 시작점을 변경하여 재호출
    public static void dfs(int cur) {
        visited[cur] = true;
        System.out.print(cur + " ");

        for(int j = 1; j <= V; j++) {
            if(link[cur][j] == 1 && !visited[j]) {
                dfs(j);
            }
        }
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        visited[start] = true;
        System.out.print(start + " ");

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int j = 1; j <= V; j++) {
                if(link[cur][j] == 1 && !visited[j]) {
                    queue.offer(j);
                    visited[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
    }
}