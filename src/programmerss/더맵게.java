package programmers;

import java.util.*;

class Solution {
  public int solution(int[] scoville, int K) {

    int answer = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    // priority queue 생성
    for (int i : scoville) {
      pq.add(i);
    }

    while (true) {
      // 최소치를 넘은 경우 종료
      if (pq.peek() >= K) break;

      // 더 이상 섞을 수 없는 경우 -1 후 종료
      if (pq.size() == 1) {
        answer = -1;
        break;
      }

      // 2개를 뽑아 섞고 다시 삽입
      pq.add(pq.poll() + pq.poll() * 2);
      answer++;
    }

    return answer;
  }
}