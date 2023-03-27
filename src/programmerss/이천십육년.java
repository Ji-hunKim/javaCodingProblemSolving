package programmers;

class Solution {
  public String solution(int a, int b) {
    String answer = "";
    int[] dayOfMonth = {31,29,31,30,31,30,31,31,30,31,30,31};
    String[] day = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
    int temp = 0;

    for(int i=0; i<a-1;i++){
      temp += dayOfMonth[i];
    }
    temp += b;
    answer = day[temp%7];
    return answer;
  }
}
