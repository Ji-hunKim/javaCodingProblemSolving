package programmers;

import java.util.*;

class Solution {
  public int solution(int k, int m, int[] score) {
    int answer = 0;
    Arrays.sort(score);
    int len = score.length;
    int index = len-m;
    for(int i=0;i<(len/m);i++){
      answer += score[index]*m;
      index = index-m;
    }
    return answer;
  }
}
