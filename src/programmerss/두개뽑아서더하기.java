package programmers;

import java.util.*;

class Solution {
  public int[] solution(int[] numbers) {
    int len = numbers.length;
    ArrayList<Integer> num = new ArrayList<Integer>();
    for(int i=0;i<len;i++){
      for(int j=i+1;j<len;j++){
        int k = numbers[i]+numbers[j];
        if(num.indexOf(k) == -1){
          num.add(k);
        }
      }
    }
    Collections.sort(num);
    int sz = num.size();
    int[] answer = new int[sz];
    for(int a=0;a<sz;a++){
      answer[a] = num.get(a);
    }
    return answer;
  }
}