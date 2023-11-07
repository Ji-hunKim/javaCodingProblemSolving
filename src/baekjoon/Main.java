package baekjoon;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] kids = new int[9];
        int sum = -100;

        for(int i=0; i<9; i++){
            int now = Integer.parseInt(br.readLine());
            kids[i] = now;
            sum += now;
        }
        int a = 0;
        int b = 0;

        Arrays.sort(kids);

        for(int i=0; i<8; i++){
            for(int j=1; j<9; j++){
                if(i==j) continue;
                if(kids[i]+kids[j] == sum){
                    a = i;
                    b = j;
                }
            }
        }

        for(int i=0; i<9; i++){
            if(i == a || i == b) continue;
            System.out.println(kids[i]);
        }

        }
}