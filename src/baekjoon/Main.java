package baekjoon;

import java.util.*;

public class Main {
    static int S;
    static int minVal = 2000;
    static int[] visited = new int[2000];
    static int[] copied = new int[2000];
    static boolean ch = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        S = sc.nextInt();
        Arrays.fill(visited, -1);
        bfs();

        System.out.println(minVal);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0, 0});
        visited[1] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cur = current[0];
            int count = current[1];
            int prev = current[2];

            if (cur == S) {
                minVal = Math.min(minVal, count);
            } else if (cur > S) {
                if (visited[cur - 1] == -1 || visited[cur - 1] >= count + 1) {
                    if (cur - 1 > 0) {
                        visited[cur - 1] = count + 1;
                        queue.offer(new int[]{cur - 1, count + 1, prev});
                    }
                }
            } else {
                if(copied[cur] == 0){
                    copied[cur] = 1;
                    queue.offer(new int[]{cur, count + 1, cur});
                }

                if (visited[cur + prev] == -1 || visited[cur + prev] >= count + 1) {
                    if (cur + prev <= 2000 && prev != 0) {
                        visited[cur + prev] = count + 1;
                        queue.offer(new int[]{cur + prev, count + 1, prev});
                    }
                }

                if (visited[cur - 1] == -1 || visited[cur - 1] >= count + 1) {
                    if (cur - 1 > 0) {
                        visited[cur - 1] = count + 1;
                        queue.offer(new int[]{cur - 1, count + 1, prev});
                    }
                }
            }
        }
    }
}