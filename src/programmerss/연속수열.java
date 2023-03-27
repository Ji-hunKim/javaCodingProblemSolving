package programmers;
import java.util.*;

class Solution {
  public int solution(int[] elements) {
    int answer = 0;
    Set<Integer> hash = new HashSet();
    int len = elements.length;
    for(int id=1; id<len+1; id++){
      for(int i=0; i<len; i++){
        int temp = 0;
        for(int k=0; k<id; k++){
          if(i+k<len) temp += elements[i+k];
          else temp += elements[i+k-len];
        }
        hash.add(temp);
      }
    }
    return hash.size();
  }
}