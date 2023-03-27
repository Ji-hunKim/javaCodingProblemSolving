package programmers;

import java.util.*;

class Solution {
  public int solution(int k, int[] tangerine) {
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

    for(int i=0; i<tangerine.length; i++){
      hm.put(tangerine[i], hm.getOrDefault(tangerine[i],0)+1);
    }

    List<Map.Entry<Integer, Integer>> entList = new ArrayList<Map.Entry<Integer, Integer>>(hm.entrySet());

    // 비교함수 Comparator를 사용하여 내림 차순으로 정렬
    Collections.sort(entList, new Comparator<Map.Entry<Integer, Integer>>() {
      // compare로 값을 비교
      public int compare(Map.Entry<Integer, Integer> obj1, Map.Entry<Integer, Integer> obj2)
      {
        // 내림 차순으로 정렬
        return obj2.getValue().compareTo(obj1.getValue());
      }
    });

    int[] answer = new int[entList.size()];
    int cnt = 0;

    // 결과
    for(Map.Entry<Integer, Integer> entry : entList) {
      k = k-entry.getValue();
      cnt++;
      if(k<=0) break;

    }
    return cnt;
  }
}
