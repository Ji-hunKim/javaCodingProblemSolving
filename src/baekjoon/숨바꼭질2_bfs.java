package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질2_bfs {
    static int N,K;
    static int count;
    static int[] min = new int[100001];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        if(N==K){
            count = 1;
        }else{
            count = 0;
            bfs();
        }

        System.out.println(min[K]);
        System.out.println(count);
    }

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        while(!queue.isEmpty()){
            int cur = queue.poll();

            if(cur == K){
                count++;
            }else{
                int next;

                next = cur*2;
                if(next <= K*2 && next <= 100000 && cur != 0){
                    if(min[next] == 0 || min[next] >= min[cur]+1){
                        min[next] = min[cur]+1;
                        queue.offer(next);
                    }
                }

                next = cur+1;
                if(next <= K && next <= 100000){
                    if(min[next] == 0 || min[next] >= min[cur]+1){
                        min[next] = min[cur]+1;
                        queue.offer(next);
                    }
                }

                next = cur-1;
                if(next <= 100000 && next >= 0){
                    if(min[next] == 0 || min[next] >= min[cur]+1){
                        min[next] = min[cur]+1;
                        queue.offer(next);
                    }
                }
            }
        }
    }
}