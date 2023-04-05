package baekjoon;

import java.util.Scanner;

public class 파이프옮기기1 {
    static int N;
    static int[][] map;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0, 1, 1);
        System.out.println(answer);
    }

    public static void dfs(int x, int y, int i) {

        if (x == N - 1 && y == N - 1) {
            answer++;
            return;
        }
        if (i == 1) {
            // 가로
            if (y + 1 < N && map[x][y + 1] == 0) dfs(x, y + 1, 1);
            if (x + 1 < N && y + 1 < N && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0 && map[x + 1][y] == 0)
                dfs(x + 1, y + 1, 2);
        } else if (i == 2) {
            // 대각선
            if (y + 1 < N && map[x][y + 1] == 0) dfs(x, y + 1, 1);
            if (x + 1 < N && y + 1 < N && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0 && map[x + 1][y] == 0)
                dfs(x + 1, y + 1, 2);
            if (x + 1 < N && map[x + 1][y] == 0) dfs(x + 1, y, 3);
        } else if (i == 3) {
            // 세로
            if (x + 1 < N && y + 1 < N && map[x][y + 1] == 0 && map[x + 1][y + 1] == 0 && map[x + 1][y] == 0)
                dfs(x + 1, y + 1, 2);
            if (x + 1 < N && map[x + 1][y] == 0) dfs(x + 1, y, 3);
        }
    }
}
