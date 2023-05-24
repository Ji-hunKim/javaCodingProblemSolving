package baekjoon;

import java.util.*;

public class Main {
    static int N;
    static int S,T;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<ArrayList<Integer>> li = new ArrayList<>();
        N = sc.nextInt();

        for(int i=0; i<N; i++) {

            S = sc.nextInt();
            T = sc.nextInt();

            if(i == 0){
                ArrayList<Integer> temp = new ArrayList<>();
                for(int k=S; k<T; k++){
                    temp.add(k);
                }
                cnt++;
                li.add(temp);
                continue;
            }

            boolean timech = false;
            int idx = 0;

            for(int j=0; j<li.size(); j++){
                ArrayList<Integer> temp = li.get(j);
                for(int k=S; k<T; k++){
                    if(temp.contains(k)){
                        break;
                    }else{
                        timech = true;
                        idx = j;
                        break;
                    }
                }
            }

            if(timech){
                for(int k=S; k<T; k++){
                    if(!li.get(idx).contains(k)){
                        li.get(idx).add(k);
                    }
                }
            }else{
                ArrayList<Integer> temp = new ArrayList<>();
                for(int k=S; k<T; k++){
                    temp.add(k);
                }
                cnt++;
                li.add(temp);
            }

        }
        System.out.println(cnt);
    }
}