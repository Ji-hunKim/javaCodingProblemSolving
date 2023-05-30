package baekjoon;

import java.util.*;

public class Main {
    static int N, K;
    static int arr[];
    static int answer = 1000000000;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int answer = 0;
        ArrayList<Integer> tall = new ArrayList<>();
        ArrayList<Integer> subTall = new ArrayList<>();

        //키 입력받기
        for(int i = 0; i<N; i++){
            tall.add(sc.nextInt());
        }
        //키 차이 구하기
        for(int i = 0; i < N-1; i++){
            subTall.add(tall.get(i+1) - tall.get(i));
        }
        //키 차이 오름차순 정렬
        Collections.sort(subTall);

        //가장 큰 키차이를 K-1개 제외하고 나머지들 더함
        for(int i = 0; i < N-K; i++){
            answer += subTall.get(i);
        }
        System.out.println(answer);
    }

}