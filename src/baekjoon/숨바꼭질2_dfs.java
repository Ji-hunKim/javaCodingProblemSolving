package baekjoon;

import java.util.*;

public class 숨바꼭질2_dfs {
    static int N,K;
    static int cnt;
    static int[] visited = new int[100005];
    static Map<Integer, Integer> hm = new HashMap<>();
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        cnt = 100005;

        Arrays.fill(visited, 100005);

        dfs(N,0);
        System.out.println(cnt);
        System.out.println(hm.get(cnt));
    }

    public static void dfs(int x, int count){
        if(visited[x] >= count && cnt >= count){
            visited[x] = count;
            if(x==K){
                cnt = Math.min(cnt ,count);
                hm.put(cnt, hm.getOrDefault(cnt, 0)+1);
            }else if(x > 0 && x <= K/2+1){
                dfs(x*2, count+1);
                dfs(x+1, count+1);
                dfs(x-1, count+1);
            }
            else if(x > K/2+1 && x < K){
                dfs(x+1, count+1);
                dfs(x-1, count+1);
            }else if(x > K){
                dfs(x-1, count+1);
            }else if(x == 0){
                dfs(x+1, count+1);
            }
        }
    }
}