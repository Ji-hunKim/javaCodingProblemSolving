package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질3 {
    static int N,K;
    static int count;
    static int[] min = new int[100001];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        if(N==K){
            count = 0;
        }else{
            count = Integer.MAX_VALUE;
            bfs();
        }
        System.out.println(count);
    }

    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{N,0});
        int cur;
        int cnt;
        int[] current;
        int next;

        while(!queue.isEmpty()){
            current = queue.poll();
            cur = current[0];
            cnt = current[1];

            if(cur == K){
                count = Math.min(count, cnt);
            }else{
                next = cur*2;
                if(next <= 100000 && next <= K*2 && cur != 0){
                    if(min[next] == 0 || min[next] >= min[cur]){
                        min[next] = min[cur];
                        queue.offer(new int[]{next, cnt});
                    }
                }

                next = cur+1;
                if(next <= 100000 && next <= K){
                    if(min[next] == 0 || min[next] >= min[cur]+1){
                        min[next] = min[cur]+1;
                        queue.offer(new int[]{next, cnt+1});
                    }
                }

                next = cur-1;
                if(next <= 100000 && next >= 0){
                    if(min[next] == 0 || min[next] >= min[cur]+1){
                        min[next] = min[cur]+1;
                        queue.offer(new int[]{next, cnt+1});
                    }
                }
            }
        }
    }
}