package baekjoon;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(bf.readLine(), " ");

        int a = Integer.parseInt(stz.nextToken());
        int b = Integer.parseInt(stz.nextToken());

        int left = 0;
        int right = b-1;

        stz = new StringTokenizer(bf.readLine(), " ");

        int[] stick = new int[b];
        int i=0;

        while(stz.hasMoreTokens()){
            stick[i] = Integer.parseInt(stz.nextToken());
            i++;
        }


        int leftVal = stick[left];
        int rightVal = stick[right];

        int answer = 0;

        while(left<right){

            if(leftVal > rightVal){
                right--;
                if(stick[right] < rightVal){
                    answer += rightVal - stick[right];
                }else{
                    rightVal = stick[right];
                }
            }else{
                left++;
                if(stick[left] < leftVal){
                    answer += leftVal - stick[left];
                }else{
                    leftVal = stick[left];
                }
            }
        }

        System.out.println(answer);


    }
}