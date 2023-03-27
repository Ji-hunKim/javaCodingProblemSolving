package programmers;

import java.util.*;
class Solution {
  public int solution(int[][] board, int[] moves) {
    int answer = 0;
    int temp = 0;
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int move:moves){
      move = move-1;
      for(int i=0;i<board.length;i++){
        temp = board[i][move];
        if(temp != 0){
          board[i][move] = 0;
          if(list.size() != 0) {
            if(list.get(list.size() - 1) == temp) {
              answer++;
              list.remove(list.size() - 1);
              break;
            }
          }
          list.add(temp);
          break;
        }
      }
    }
    return answer*2;
  }
}