package leetcode;

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        List<Map.Entry<Integer, Integer>> entList = new ArrayList<>(map.entrySet());

        Collections.sort(entList, new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> obj1, Map.Entry<Integer, Integer> obj2){
                if(obj1.getValue() < obj2.getValue()) return 1;
                if(obj1.getValue() > obj2.getValue()) return -1;
                else{
                    return obj1.getKey() - obj2.getKey();
                }

            }
        });
        int num = entList.get(k-1).getValue();
        List<Integer> temp = new ArrayList<>();
        int[] answer;

        for(int i=0; i<entList.size(); i++){
            if(entList.get(i).getValue() >= num){
                temp.add(entList.get(i).getKey());
            }
        }
        answer = new int[temp.size()];
        for(int i=0; i<temp.size(); i++){
            answer[i] = temp.get(i);
        }
        return answer;
    }
}