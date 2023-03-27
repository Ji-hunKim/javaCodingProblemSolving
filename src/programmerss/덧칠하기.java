package programmers;

class Solution {
  public int solution(int n, int m, int[] section) {
    int answer = 1;
    int temp = section[0] + m;

    if(section.length == 0) return answer;

    for(int i=1; i<section.length; i++){
      if(section[i] >= temp){
        answer++;
        temp = section[i] + m;
      }
    }
    return answer;
  }
}
