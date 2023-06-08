package baekjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 우체국 {

        public static void main(String[] args) {
            Scanner scann = new Scanner(System.in);
            int N = scann.nextInt();
            long[][] arr = new long[N][2];
            long sum=0;
            long cnt=0;
            for(int i=0;i<N;i++) {
                arr[i][0] = scann.nextLong();
                arr[i][1] = scann.nextLong();

                cnt+=arr[i][1];
            }
            Arrays.sort(arr, new Comparator<long[]>() {
                @Override
                public int compare(long[] n1, long[] n2) {
                    if(n1[0]==n2[0]) return (int)(n1[1]-n2[1]);
                    return (int)(n1[0]-n2[0]);
                }
            });
            for(int i=0;i<N;i++) {
                sum+=arr[i][1];
                if(sum>=(cnt+1)/2) {
                    System.out.println(arr[i][0]);
                    break;
                }
            }
        }
    }