package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 최소비용구하기 {
    static int n, m;
    static ArrayList<baekjoon.Node>[] list;
    static int dist[];
    static boolean visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        n = sc.nextInt();
        m = sc.nextInt();


        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int w = sc.nextInt();
            list[start].add(new baekjoon.Node(end, w));
        }

        int start_city = sc.nextInt();
        int end_city = sc.nextInt();


        djikstra(start_city);

        System.out.println(dist[end_city]);
    }

    public static void djikstra(int start_city) {
        PriorityQueue<baekjoon.Node> pq = new PriorityQueue<>();
        pq.add(new baekjoon.Node(start_city, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start_city] = 0;

        while (!pq.isEmpty()) {
            baekjoon.Node cur = pq.poll();

            visited[cur.city] = true;

            for (baekjoon.Node next : list[cur.city]) {
                if (visited[next.city]) {
                    continue;
                }
                if (dist[next.city] > dist[cur.city] + next.w) {
                    dist[next.city] = dist[cur.city] + next.w;
                    pq.add(new baekjoon.Node(next.city, dist[next.city]));
                }

            }
        }

    }
}

class Node implements Comparable<baekjoon.Node> {
    int city, w;

    Node(int city, int w) {
        this.city = city;
        this.w = w;
    }

    public int compareTo(baekjoon.Node o) {
        return this.w - o.w;
    }
}
