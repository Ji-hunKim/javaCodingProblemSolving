package baekjoon;

import java.util.*;

public class 연산자끼워넣기 {

    static int maxVal = Integer.MIN_VALUE;
    static int minVal = Integer.MAX_VALUE;
    static int[] nums;
    static int[] cal = new int[4];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n];

        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }

        for(int i=0; i<4; i++){
            cal[i] = sc.nextInt();
        }

        dfs(1, nums[0]);

        System.out.println(maxVal);
        System.out.println(minVal);
    }

    public static void dfs(int idx, int val){
        if(idx >= n) {
            maxVal = Math.max(maxVal, val);
            minVal = Math.min(minVal, val);
            return;
        }else{
            for(int i=0; i<4; i++){
                if(cal[i] != 0){
                    cal[i]--;
                    switch(i){
                        case 0:
                            dfs(idx+1, val+nums[idx]);
                            break;
                        case 1:
                            dfs(idx+1, val-nums[idx]);
                            break;
                        case 2:
                            dfs(idx+1, val*nums[idx]);
                            break;
                        case 3:
                            dfs(idx+1, val/nums[idx]);
                            break;
                    }
                    cal[i]++;
                }
            }
        }
    }
}