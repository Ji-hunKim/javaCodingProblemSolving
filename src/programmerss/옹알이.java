package programmers;

import java.util.ArrayList;

class Solution {
  public int solution(String[] babbling) {
    int answer = 0;
    String[] speakList = {"aya", "ye", "woo", "ma"};
    String[] banList = {"ayaaya", "yeye" , "woowoo", "mama"};
    for(String bab : babbling) {
      for(String ban : banList) {
        bab = bab.replace (ban, "X");
      }
      for(String speak : speakList) {
        bab = bab.replace (speak, "?");
      }
      int sign = 0;
      for(int i = 0; i < bab.length(); i++) {
        if(!bab.subSequence (i, i+1).equals ("?")) {
          sign = 1;
          break;
        }
      }
      if(sign == 0) {
        answer++;
      }
    }
    return answer;
  }
}