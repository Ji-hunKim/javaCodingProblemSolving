package programmers;

public class 문자열내마음대로정렬하기 import java.util.*;

class Solution {
  public String[] solution(String[] strings, int n) {
    String[] answer = {};
    ArrayList<String> list = new ArrayList<>();

    for (int i = 0; i < strings.length; i++) {
      list.add(strings[i].charAt(n) + strings[i]);
    }

    // 정렬
    Collections.sort(list);

    answer = new String[list.size()];

    for (int i = 0; i < list.size(); i++) {
      answer[i] = list.get(i).substring(1);
    }

    return answer;
  }
}{
}
