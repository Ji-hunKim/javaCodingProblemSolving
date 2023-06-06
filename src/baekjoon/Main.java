package baekjoon;

import java.util.*;

public class Main {
    static int N,M;
    static ArrayList<Integer> crane;
    static ArrayList<Integer> box;
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        crane = new ArrayList<>();
        for(int i=0; i<N; i++) {
            crane.add(sc.nextInt());
        }

        M = sc.nextInt();
        box = new ArrayList<>();
        for(int i=0; i<M; i++) {
            box.add(sc.nextInt());
        }

        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        if(box.get(0) > crane.get(0)) {
            System.out.println(-1);
            return;
        }

        int ans = 0;

        while(!box.isEmpty()) {
            int bidx =0;
            for(int i=0; i< N; ) {
                if(bidx == box.size()) break;
                else if(crane.get(i) >= box.get(bidx)) {
                    box.remove(bidx);
                    i++;
                }else bidx++;
            }
            ans++;
        }

        System.out.println(ans);

    }
}