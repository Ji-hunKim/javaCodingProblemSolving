package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class 스카이라인쉬운거 {

    static int N, x, y;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        int[] arr = new int[50002];
        int answer = 0;

        for(int i = 0; i < N; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            arr[i] = y;
        }

        int cur;

        Stack<Integer> stk = new Stack<Integer>();
        for(int i = 0; i <= N; i++){
            cur = arr[i];

            while(!stk.empty() && stk.peek() > cur){
                answer += 1;
                stk.pop();
            }

            if(!stk.empty() && stk.peek() == cur)
                continue;

            stk.push(cur);
        }

        System.out.println(answer);
    }
}