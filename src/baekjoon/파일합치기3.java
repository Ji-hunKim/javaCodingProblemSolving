package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 파일합치기3 {

    static int N;
    static int K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        PriorityQueue<Long> queue = new PriorityQueue<>();
        List<Long> li = new ArrayList<>();

        long a;
        long b;
        long answer;
        long sum;

        for(int i=0; i<N; i++){
            K = sc.nextInt();
            answer = 0;

            for(int j=0; j<K; j++){
                queue.offer(sc.nextLong());
            }

            while(queue.size() > 1){
                a = queue.poll();
                b = queue.poll();

                sum = a+b;
                answer += sum;
                queue.offer(sum);
            }

            queue.clear();
            li.add(answer);
        }

        for(int i=0; i<li.size(); i++){
            System.out.println(li.get(i));
        }
    }
}