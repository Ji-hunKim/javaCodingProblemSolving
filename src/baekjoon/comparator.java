package baekjoon;

import java.util.*;

public class comparator {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        hm.put(5,5);
        hm.put(1,8);
        hm.put(5,hm.getOrDefault(5,0)+3);

        List<Map.Entry<Integer,Integer>> hmList = new ArrayList<>(hm.entrySet());

        Collections.sort(hmList, new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> obj1, Map.Entry<Integer, Integer> obj2){
                if(obj2.getValue()<obj1.getValue()) return -1;
                else if(obj2.getValue()>obj1.getValue()){
                    return 1;
                }
                else{
                    return obj2.getKey() - obj1.getKey();
                }
            }
        });

        System.out.println(hmList.get(0).getKey());
    }
}
