package programmers;

import java.util.*;
class Solution {

    static HashMap<String,Integer> map;

    public static void combi(String ord, StringBuilder sb, int idx, int cnt, int cr){
        if(cnt == cr) {
            map.put(sb.toString(),map.getOrDefault(sb.toString(),0)+1);
            return;
        }

        for(int i = idx; i<ord.length(); i++){
            sb.append(ord.charAt(i));
            combi(ord,sb,i+1,cnt+1,cr);
            sb.delete(cnt,cnt+1);
        }
    }

    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();

        // 오름차순으로 변경
        for(int i =0;i<orders.length;i++){
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }

        for(int cor : course){
            map = new HashMap<>();
            int max = Integer.MIN_VALUE;
            for(String order : orders){
                StringBuilder sb = new StringBuilder();
                if(order.length() >= cor)
                    combi(order,sb,0,0,cor);
            }

            for(Map.Entry<String,Integer> entry : map.entrySet()){
                max = Math.max(max,entry.getValue());

            }
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                if(max >=2 && entry.getValue() == max)
                    answer.add(entry.getKey());
            }
        }
        Collections.sort(answer);

        return answer;
    }
}