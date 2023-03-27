package programmers;

class Solution {
  public int[] solution(int[] prices) {

    int len = prices.length;
    int[] answer = new int[len];

    for(int i=0; i<len; i++){
      int temp = 0;
      boolean ch = true;
      for(int j=i+1; j<len; j++){
        if(prices[i]<=prices[j]) temp++;
        else {
          temp++;
          break;
        }
      }
      answer[i] = temp;
    }
    return answer;
  }
}