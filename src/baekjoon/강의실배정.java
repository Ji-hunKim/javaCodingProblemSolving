package baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 강의실배정 {
        static int N;
        static int cnt = 0;
        static int arr[][];

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();

            arr = new int[N][2];

            for (int i = 0; i < N; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] obj1, int[] obj2) {
                    if(obj1[0] == obj2[0]) return obj1[1] - obj2[1];
                    else return obj1[0]-obj2[0];
                }
            });

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.offer(arr[0][1]);
            cnt++;

            int now;
            int next;
            int nextEnd;
            for(int i=1; i<arr.length; i++){
                now = pq.poll();
                next = arr[i][0];
                nextEnd = arr[i][1];

                if(next < now) {
                    pq.add(now);
                    cnt++;
                }

                pq.add(nextEnd);
            }
            System.out.println(cnt);
        }
    }