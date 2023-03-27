package programmers;

class Solution {
  public int solution(int n) {
    int answer = 0;
    String temp = "";
    while(n>0){
      int namuji = n % 3;
      n = n/3;

      temp += String.valueOf(namuji);
    }

    for(int i = temp.length()-1; i>=0; i--){
      int tnt = temp.charAt(i)-'0';
      answer += tnt * Math.pow(3,(temp.length()-1)-i);
    }
    return answer;
  }
}
