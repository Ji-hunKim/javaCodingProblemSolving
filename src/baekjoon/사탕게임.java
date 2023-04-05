package baekjoon;

import java.util.Scanner;

public class 사탕게임 {
    static int N;
    static String[][] map;
    static int answer = 0;

    static int maxVal = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new String[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = sc.next().split("");
        }

        String temp = "";
        int cnt = 0;
        String cur = "";

        //가로
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                temp = map[i][j];
                map[i][j] = map[i][j + 1];
                map[i][j + 1] = temp;
                for (int a = 0; a < N; a++) {
                    cnt = 0;
                    cur = map[a][0];
                    for (int b = 0; b < N; b++) {
                        if (cur.equals(map[a][b])) {
                            cnt++;
                            maxVal = Math.max(maxVal, cnt);
                        } else {
                            cur = map[a][b];
                            maxVal = Math.max(maxVal, cnt);
                            cnt = 1;
                        }
                    }
                }
                for (int a = 0; a < N; a++) {
                    cnt = 0;
                    cur = map[0][a];
                    for (int b = 0; b < N; b++) {
                        if (cur.equals(map[b][a])) {
                            cnt++;
                            maxVal = Math.max(maxVal, cnt);
                        } else {
                            cur = map[b][a];
                            maxVal = Math.max(maxVal, cnt);
                            cnt = 1;
                        }
                    }
                }
                map[i][j + 1] = map[i][j];
                map[i][j] = temp;
            }
        }

        //세로
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                temp = map[j][i];
                map[j][i] = map[j + 1][i];
                map[j + 1][i] = temp;
                for (int a = 0; a < N; a++) {
                    cnt = 0;
                    cur = map[a][0];
                    for (int b = 0; b < N; b++) {
                        if (cur.equals(map[a][b])) {
                            cnt++;
                            maxVal = Math.max(maxVal, cnt);
                        } else {
                            cur = map[a][b];
                            maxVal = Math.max(maxVal, cnt);
                            cnt = 1;
                        }
                    }
                }
                for (int a = 0; a < N; a++) {
                    cnt = 0;
                    cur = map[0][a];
                    for (int b = 0; b < N; b++) {
                        if (cur.equals(map[b][a])) {
                            cnt++;
                            maxVal = Math.max(maxVal, cnt);
                        } else {
                            cur = map[b][a];
                            maxVal = Math.max(maxVal, cnt);
                            cnt = 1;
                        }
                    }
                }
                map[j + 1][i] = map[j][i];
                map[j][i] = temp;
            }
        }
        System.out.println(maxVal);
    }
}
