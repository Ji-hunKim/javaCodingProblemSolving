package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용돈관리 {
    public static int n,m;
    public static int arr[];
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr=new int[n];
        int start=0;
        int end=0;

        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(br.readLine());
            end+=arr[i];
            if(start<arr[i]){
                start=arr[i];
            }
        }

        while(start<=end){
            int mid=(start+end)/2;
            int sum=0;
            int cnt=0;

            for(int i=0;i<n;i++){
                if(sum+arr[i]>mid){
                    cnt++;
                    sum=0;
                }
                sum+=arr[i]; //집어넣고 다시 k원 인출 가능
            }
            if(sum!=0){
                cnt++;
            }
            if(cnt>m){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        System.out.println(start);
    }
}
