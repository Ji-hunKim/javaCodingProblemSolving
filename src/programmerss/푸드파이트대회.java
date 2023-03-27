package programmers;

class Solution {
  public String solution(int[] food) {
    String answer = "";
    for(int i=1;i<food.length;i++){
      for(int j=0;j<food[i]/2;j++){
        answer += String.valueOf(i);
      }
    }
    String temp = new String(answer);
    answer += "0";
    for(int k=temp.length()-1;k>-1;k--){
      answer += String.valueOf(temp.charAt(k));
    }
    return answer;
  }
}