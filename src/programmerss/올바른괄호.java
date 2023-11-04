package programmers;

import java.util.*;

class Solution {
  boolean solution(String s) {

    boolean answer = true;
    Stack<Character> stk = new Stack<>();

    stk.push(s.charAt(0));

    for(int i=1; i<s.length(); i++){
      char now = s.charAt(i);

      if(now == '('){
        stk.push(now);
      }else{
        if(stk.size() == 0) {
          answer = false;
          break;
        }else{
          stk.pop();
        }
      }
    }

    if(stk.size() > 0) answer = false;

    return answer;
  }
}