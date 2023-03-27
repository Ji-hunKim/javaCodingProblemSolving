package programmers;

import java.util.*;
class Solution {
  public int solution(String s) {
    int answer = 0;
    int len = s.length();
    for(int i=0; i<len; i++){
      s = s.substring(1,len) + s.charAt(0);
      List<Character> list = new ArrayList<>();
      boolean check = true;
      for(int j=0; j<len; j++){
        char temp = s.charAt(j);
        if(temp == '(' || temp=='{' || temp=='['){
          list.add(temp);
        }
        else if(temp == ')'){
          if(list.size() == 0){
            check = false;
            break;
          }
          else if(list.get(list.size()-1) != '(') {
            check = false;
            break;
          }
          else{
            list.remove(list.size()-1);
          }
        }
        else if(temp == '}'){
          if(list.size() == 0){
            check = false;
            break;
          }
          else if(list.get(list.size()-1) != '{') {
            check = false;
            break;
          }
          else{
            list.remove(list.size()-1);
          }
        }
        else if(temp == ']'){
          if(list.size() == 0){
            check = false;
            break;
          }
          else if(list.get(list.size()-1) != '[') {
            check = false;
            break;
          }
          else{
            list.remove(list.size()-1);
          }
        }
      }
      if(list.size() != 0) check = false;
      if(check) answer++;
    }
    return answer;
  }
}
