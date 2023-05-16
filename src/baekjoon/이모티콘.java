package baekjoon;

import java.util.*;

public class 이모티콘 {

    static boolean[][] visited = new boolean[1001][1001];//[clipboard][total]

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int s = scan.nextInt();

        bfs(s);
    }

    public static void bfs(int s) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 1, 0});
        visited[0][1] = true;

        int clipboard;
        int total;
        int time;

        while(!q.isEmpty()) {
            int[] current = q.poll();

            clipboard = current[0];
            total = current[1];
            time = current[2];

            if(total == s) {
                System.out.println(time);
                return;
            }

            // 1. 화면에 있는 이모티콘 클립보드에 저장
            q.offer(new int[]{total, total, time + 1});


            // 2. 클립보드에 있는 이모티콘 붙여넣기.
            // 클립보드 비어있지 않아야하고, 붙여넣은 후 개수가 총 개수보다 적어야 하며, 이전에 방문한적 없어야함.
            if(clipboard != 0 && total + clipboard <= s && !visited[clipboard][total + clipboard]) {
                q.offer(new int[]{clipboard, total + clipboard, time + 1});
                visited[clipboard][total + clipboard] = true;
            }

            // 3. 화면에 있는 이모티콘 중 하나 삭제.
            // 총 개수 1보다 크거나 같아야하고, 방문한적 없어야함.
            if(total >= 1 && !visited[clipboard][total - 1]) {
                q.offer(new int[]{clipboard, total - 1, time + 1});
                visited[clipboard][total - 1] = true;
            }
        }
    }
}
