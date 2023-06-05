package baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 최소회의실개수 {


    static int N;
    static int arr[][];
    static int cnt;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        arr = new int[N][2];

        for(int i=0; i<N; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2[0]){
                    return 1;
                } else if(o1[0] == o2[0]){
                    if(o1[1] > o2[1]) return 1;
                    else return -1;
                } else {
                    return -1;
                }
            }
        });


        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(arr[0][1]);
        cnt++;

        int k=1;

        while(true){
            if(k>=N) break;
            if(pq.peek() > arr[k][0]){
                cnt++;
            }else{
                pq.poll();
            }
            pq.offer(arr[k][1]);
            k++;
        }

        System.out.println(cnt);
    }

}