package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 카드정렬하기 {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        PriorityQueue<Long> queue = new PriorityQueue<>();

        long a;
        long b;
        long answer;
        long sum;

        answer = 0;

        for(int j=0; j<N; j++){
            queue.offer(sc.nextLong());
        }

        while(queue.size() > 1){
            a = queue.poll();
            b = queue.poll();

            sum = a+b;
            answer += sum;
            queue.offer(sum);
        }

        System.out.println(answer);
    }
}