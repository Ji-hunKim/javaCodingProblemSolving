package programmers;

import java.util.*;

class Solution {
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;
    List<ArrayList<Integer>> onBridge = new ArrayList<>();
    int j = 0;

    while(true){
      answer++;
      int nowBridge = 0;
      int i = 0;
      while(true){
        if(onBridge.size() == 0) break;

        int remainTime = onBridge.get(i).get(1);
        remainTime--;
        if(remainTime == 0) {
          onBridge.remove(i);
        }else{
          onBridge.get(i).set(1,remainTime);
          nowBridge += onBridge.get(i).get(0);
          i++;
        }

        if(i >= onBridge.size()) break;
      }
      if(j < truck_weights.length){
        if(nowBridge + truck_weights[j] <= weight){
          ArrayList<Integer> temp = new ArrayList<Integer>();
          temp.add(truck_weights[j]);
          temp.add(bridge_length);
          onBridge.add(temp);
          j++;
        }
      }else{
        if(onBridge.size() == 0) break;
      }
    }
    return answer;
  }
}
