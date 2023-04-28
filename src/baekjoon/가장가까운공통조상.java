package baekjoon;

import java.util.*;

public class 가장가까운공통조상 {
    static int T;
    static List<int[]> map;
    static int N;
    static int A, B;

    static List<Integer> listA;
    static List<Integer> listB;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        int[] result = new int[T];

        for(int t=0; t<T; t++){
            N = sc.nextInt();
            map = new ArrayList<>();
            for(int i=0; i<N-1; i++){
                map.add(new int[]{sc.nextInt(), sc.nextInt()});
            }
            A = sc.nextInt();
            B = sc.nextInt();

            listA = new ArrayList<>();
            listB = new ArrayList<>();

            bfsA();
            bfsB();

            Loop1:
            for(int i=0; i<listA.size(); i++){
                for(int j=0; j<listB.size(); j++){
                    if(listA.get(i) == listB.get(j)){
                        result[t] = listA.get(i);
                        break Loop1;
                    }
                }
            }

        }

        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }

    public static void bfsA(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(A);
        listA.add(A);


        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i=0; i<N-1; i++){
                int[] curMap = map.get(i);
                if(curMap[1] == cur){
                    queue.offer(curMap[0]);
                    listA.add(curMap[0]);
                    break;
                }
            }
        }
    }

    public static void bfsB(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(B);
        listB.add(B);

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i=0; i<N-1; i++){
                int[] curMap = map.get(i);
                if(curMap[1] == cur){
                    queue.offer(curMap[0]);
                    listB.add(curMap[0]);
                    break;
                }
            }
        }
    }
}