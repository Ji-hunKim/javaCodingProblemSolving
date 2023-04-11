package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class 음식물피하기 {
    static int N, M;
    static int K;
    static int[][] maps;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int maxVal;
    static int temp;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        maps = new int[N][M];
        visited = new boolean[N][M];

        int x = 0;
        int y = 0;

        for (int i = 0; i < K; i++) {
            x = sc.nextInt();
            y = sc.nextInt();
            maps[x-1][y-1] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                temp = 0;
                if (!visited[i][j] && maps[i][j] == 1) {
                    dfs(i, j);
                }
                maxVal = Math.max(maxVal, temp);
            }
        }
        System.out.println(maxVal);
    }

    public static void dfs(int x, int y) {
        temp++;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            if (!visited[nx][ny] && maps[nx][ny] == 1) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }
    }
}