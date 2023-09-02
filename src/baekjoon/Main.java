package baekjoon;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());


        int N=Integer.parseInt(st.nextToken());
        int H=Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int left = 0;
        int right = arr[N-1];

        while(left <= right){
            int mid = (left+right)/2;
            long sum = 0;
            for(int tree : arr){
                if(tree-mid > 0){
                    sum += (tree-mid);
                }
            }
            if(sum >= H){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }

        System.out.println(right);
        br.close();
    }
}
