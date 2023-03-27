package programmers;
class Solution {
  public int solution(int n) {
    int answer = 1;
    for(int i=1;i<n;i++){
      int temp = 0;
      for(int j=i;j<n+1;j++){
        temp += j;
        if(temp == n){
          answer += 1;
          break;
        }
        else if(temp>n) break;
      }
    }
    return answer;
  }
}