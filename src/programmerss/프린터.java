package programmers;

import java.util.*;

class Solution {
  public int solution(int[] priorities, int location) {
    int answer = 0;
    List<Integer> li = new ArrayList<Integer>();

    for(int i=0; i<priorities.length; i++){
      li.add(priorities[i]);
    }

    while(true){
      int pri = li.get(0);
      boolean ch = false;

      for(int i=0; i<li.size(); i++){
        if(pri<li.get(i)){
          ch = true;
          break;
        }
      }

      if(ch==true){
        li.remove(0);
        li.add(pri);
        if(location == 0) location = li.size()-1;
        else location--;
        ch = false;
      }
      else{
        answer++;
        li.remove(0);
        if(location == 0) break;
        else location--;
      }
    }
    return answer;
  }
}
