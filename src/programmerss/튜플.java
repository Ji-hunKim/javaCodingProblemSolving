package programmers;

import java.util.*;

class Solution {
  public int[] solution(String s) {

    String newString = s.replaceAll("[\\{\\}]", "");
    String newString2 = newString.replaceAll("[,]", " ");
    String strArr[] = newString.split(",");

    HashMap<String, Integer> hmap = new HashMap<String, Integer>();

    for(int i=0; i<strArr.length; i++){
      String tempStr = strArr[i];
      hmap.put(tempStr, hmap.getOrDefault(tempStr, 0)+1);
    }


    // Map.Entry 리스트 작성
    List<Map.Entry<String, Integer>> entList = new ArrayList<Map.Entry<String, Integer>>(hmap.entrySet());

    // 비교함수 Comparator를 사용하여 내림 차순으로 정렬
    Collections.sort(entList, new Comparator<Map.Entry<String, Integer>>() {
      // compare로 값을 비교
      public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2)
      {
        // 내림 차순으로 정렬
        return obj2.getValue().compareTo(obj1.getValue());
      }
    });

    int[] answer = new int[entList.size()];
    int id = 0;
    // 결과
    for(Map.Entry<String, Integer> entry : entList) {
      answer[id] = Integer.parseInt(entry.getKey());
      id++;
    }

    return answer;
  }
}