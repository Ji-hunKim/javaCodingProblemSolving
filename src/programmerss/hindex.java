package programmers;

import java.util.*;
class Solution {
  public int solution(int[] citations) {
    int max = 0;
    Arrays.sort(citations);
    int len = citations.length;
    for(int j=0; j<citations[len-1]+1; j++){
      int sang = 0;
      int ha = 0;
      for(int i=0; i<len; i++){
        if(citations[i] >= j){
          sang++;
        }
        else if(citations[i] <= j){
          ha++;
        }
      }
      if(sang >= j && ha <= j && j>max) max = j;
    }
    return max;
  }
}