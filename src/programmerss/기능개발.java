package programmers;

import java.util.*;

class Solution {
  public int[] solution(int[] progresses, int[] speeds) {
    int days = 0;
    int temp = 0;
    ArrayList<Integer> arr = new ArrayList<Integer>();

    if(progresses.length == 1) {
      int[] answer = new int[1];
      answer[0] = 1;
      return answer;
    }

    for(int i=0; i<progresses.length; i++){
      int leftpro = 100-progresses[i];
      int leftdays = (int)Math.ceil(leftpro/speeds[i]);
      if(leftpro%speeds[i] != 0) leftdays++;
      if(leftdays > days){
        days = leftdays;
        if(i != 0) {
          arr.add(temp);
        }
        temp = 1;
        if(i == progresses.length-1){
          arr.add(temp);
        }
      }
      else{
        temp++;
        if(i == progresses.length-1){
          arr.add(temp);
        }
      }
    }
    int[] answer = new int[arr.size()];
    for(int i=0; i<arr.size(); i++){
      answer[i] = arr.get(i);
    }

    return answer;
  }
}