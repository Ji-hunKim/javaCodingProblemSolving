package baekjoon;

import java.util.*;

class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] height = new int[9];
        int sum = 0;
        int h = 0;

        for(int i=0; i<9; i++){
            h = sc.nextInt();
            height[i] = h;
            sum += h;
        }

        int a = 0;
        int b = 0;

        Arrays.sort(height);

        Loop1:
        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                if(sum - height[i] - height[j] == 100){
                    a = i;
                    b = j;
                    break Loop1;
                }
            }
        }

        for(int i=0; i<9; i++){
            if(i != a && i != b){
                System.out.println(height[i]);
            }
        }
    }
}