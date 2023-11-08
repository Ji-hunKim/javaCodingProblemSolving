package baekjoon;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int A = 0;
        int B = 0;

        if(a == b){
            System.out.println(a);
            System.out.println(b);
            System.exit(0);
        }

        int k = Math.max(a,b)/2;

        boolean flag = false;

        while(k>0){
            if(a%k == 0 && b%k == 0){
                flag = true;
                A = k;
                B = k*(a/k)*(b/k);
                break;
            }
            k--;
        }

        System.out.println(A);
        System.out.println(B);

    }
}