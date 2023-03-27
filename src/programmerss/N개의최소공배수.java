package programmers;

import java.util.*;
class Solution {
  public int solution(int[] arr) {
    int answer = 1;
    int na = 1;
    Arrays.sort(arr);
    int len = arr.length;
    int max = arr[len-1]+1;
    int j = 2;
    while(j<max){
      int cnt = 0;
      for(int i=0; i<len; i++){
        if(arr[i] % j==0){
          cnt++;
        }
      }
      if(cnt>=2){
        for(int i=0; i<len; i++){
          if(arr[i] % j==0){
            arr[i] = arr[i]/j;
          }
        }
        na *= j;
      }
      else{
        j++;
      }
    }
    for(int i=0; i<len; i++){
      answer *= arr[i];
      System.out.println(arr[i]);
    }
    return answer*na;
  }
}
