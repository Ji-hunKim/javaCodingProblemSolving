package baekjoon;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        long max=0;
        long mid=0;
        long min=0;

        int arr[] = new int[K];
        for (int i = 0; i < K; i++) {
            int number = Integer.parseInt(br.readLine());
            arr[i] = number;
            if(number>max){
                max = number;
            }
        }
        max++; //+1을 더 해서 시작
        long n;
        while(min<max){
            n=0;
            mid = (min + max) / 2;
            //mid의 랜선의 길이면 필요한 개수 N이 맞는지 검사
            for(int i=0; i<K; i++){
                n += (arr[i]/mid);
            }

            if(n<N){ // 랜선 개수가 모자라면 max값을 줄임
                max = mid;
            }
            else{
                min = mid +1;
            }
        }
        System.out.print(min-1);
    }
}
