package programmers;

class Solution {
  public int solution(int a, int b, int n) {
    int answer = 0;
    int temp = 1;

    while(temp>0){
      temp = n / a;
      answer += b*temp;
      n = n - temp*a + b*temp;
    }

    return answer;
  }
}
