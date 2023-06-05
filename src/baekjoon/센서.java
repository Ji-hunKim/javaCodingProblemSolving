package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 센서 {

    static int N,K;
    static int cnt;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        List<Integer> arr = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int now;

        for(int i=0; i<N; i++){
            now = sc.nextInt();
            if(arr.contains(now)){
                continue;
            }else{
                arr.add(now);
            }

        }

        Collections.sort(arr);

        int len = arr.size();
        int a;
        for(int i=1; i<len; i++){
            a = arr.get(i) - arr.get(i-1);
            temp.add(a);
        }

        Collections.sort(temp);

        for(int i=0; i<len-K; i++){
            cnt += temp.get(i);
        }
        System.out.println(cnt);
    }

}