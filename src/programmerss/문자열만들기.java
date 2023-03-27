package programmers;

class Solution {
  public String solution(String s) {
    String answer = "";
    s = s.toLowerCase();
    for(int i=0;i<s.length();i++){
      char temp = s.charAt(i);
      if(i==0){
        if(Character.isDigit(temp)) answer += temp;
        else answer += Character.toUpperCase(temp);
      }
      else{
        if(s.charAt(i-1) == ' ') answer += Character.toUpperCase(temp);
        else answer += temp;
      }
    }
    return answer;
  }
}