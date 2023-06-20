package baekjoon;

import java.util.*;

public class 볼모으기 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String balls = sc.next();
        int cnt = Integer.MAX_VALUE;


        // 왼쪽으로 빨간 공 모으기

        int subCnt = 0;
        boolean sw = false;
        for (int i = 0; i < N; i++) {
            if (sw && balls.charAt(i) == 'R') {
                subCnt++;
                continue;
            }

            if (balls.charAt(i) == 'B') sw = true;
        }
        cnt = Math.min(cnt, subCnt);

        // 왼쪽으로 파란 공 모으기

        subCnt = 0;
        sw = false;
        for (int i = 0; i < N; i++) {
            if (sw && balls.charAt(i) == 'B') {
                subCnt++;
                continue;
            }

            if (balls.charAt(i) == 'R') sw = true;
        }
        cnt = Math.min(cnt, subCnt);


        // 오른쪽으로 빨간 공 모으기

        subCnt = 0;
        sw = false;
        for (int i = N - 1; i >= 0; i--) {
            if (sw && balls.charAt(i) == 'R') {
                subCnt++;
                continue;
            }

            if (balls.charAt(i) == 'B') sw = true;
        }
        cnt = Math.min(cnt, subCnt);

        // 오른쪽으로 파란 공 모으기

        subCnt = 0;
        sw = false;
        for (int i = N - 1; i >= 0; i--) {
            if (sw && balls.charAt(i) == 'B') {
                subCnt++;
                continue;
            }

            if (balls.charAt(i) == 'R') sw = true;
        }

        cnt = Math.min(cnt, subCnt);


        System.out.println(cnt);


    }
}