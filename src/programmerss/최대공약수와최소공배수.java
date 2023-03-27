package programmers;

class Solution {
  public int[] solution(int n, int m) {
    int[] answer = new int[2];
    int k = 1;
    for(int i = m; i>0; i--){
      if(n%i == 0 && m%i == 0) {
        k *= i;
        n /= i;
        m /= i;
      }
    }
    if(k == 1){
      answer[0] = 1;
      answer[1] = n*m;
    }
    else{
      answer[0] = k;
      answer[1] = k*n*m;
    }
    return answer;
  }
}