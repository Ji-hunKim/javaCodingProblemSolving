package baekjoon;

import java.util.*;

public class 텀프로젝트 {
    static int[] students; // 학생 배열
    static int[] check; // 몇 번째로 방문하는 것인지
    static int[] startV; // 시작 정점
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- >0){
            int N = sc.nextInt();
            students = new int[N+1];
            check = new int[N+1];
            startV = new int[N+1];

            for (int i=1; i<=N; i++)
                students[i] = sc.nextInt();
            int result = 0;
            for (int i=1; i<=N; i++){
                if (check[i]==0) // 방문하지 않았다면
                    result += dfs(i, 1, i);
            }
            System.out.println(N-result);
        }
    }
    static int dfs(int i, int cnt, int start){
        if (check[i] != 0){ // 이미 방문했던 정점이면
            if (start != startV[i]) // 시작 정점과 다른지 확인
                return 0;
            return cnt-check[i]; // 같으면 몇 번째 방문한 정점인지
        }
        check[i] = cnt; // 몇 번째 방문한건지 저장
        startV[i] = start;
        return dfs(students[i], cnt+1, start);
    }
}