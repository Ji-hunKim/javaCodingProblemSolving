package programmers;

import java.util.*;

class Solution {
  public int[] solution(String msg) {
    String[] alpha = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    Map<String, Integer> hm = new HashMap<String, Integer>();
    for(int i=0; i<alpha.length; i++){
      hm.put(alpha[i], i+1);
    }

    List<Integer> ans = new ArrayList<Integer>();

    int len = msg.length();

    int i = 0;
    while(i < len){
      String temp = String.valueOf(msg.charAt(i));
      int val = 0;

      while(hm.containsKey(temp)){
        val = hm.get(temp);
        i++;
        if(i!=len){
          temp += String.valueOf(msg.charAt(i));
        } else{
          break;
        }
      }
      hm.put(temp, hm.size()+1);
      ans.add(val);
    }

    int[] answer = new int[ans.size()];
    for(int k=0; k<ans.size(); k++){
      answer[k] = ans.get(k);
    }
    return answer;
  }
}
