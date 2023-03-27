package programmers;

import java.util.*;
class Solution {
  public int solution(int cacheSize, String[] cities) {
    int answer = 0;
    List<String> list = new ArrayList<String>();
    if(cacheSize == 0){
      answer = 5*cities.length;
      return answer;
    }

    for(int i=0; i<cities.length; i++){
      String city = cities[i].toLowerCase();
      if(list.contains(city)) {
        list.remove(city);
        list.add(0, city);
        answer++;
      }
      else{
        if(list.size() == cacheSize){
          list.remove(cacheSize-1);
          list.add(0, city);
          answer += 5;
        }
        else{
          list.add(0, city);
          answer += 5;
        }
      }
    }

    return answer;
  }
}