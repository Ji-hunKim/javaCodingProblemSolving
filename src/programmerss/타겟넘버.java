package programmers;

class Solution {
  static int answer = 0;

  public int solution(int[] numbers, int target) {
    int id = 0;
    int len = numbers.length;
    dfs(numbers, +numbers[id], id+1, len, target);
    dfs(numbers, -numbers[id], id+1, len, target);
    return answer;
  }

  private  void dfs(int[] numbers, int num, int id, int len, int target){
    if(id < len) {
      dfs(numbers, num+numbers[id], id+1, len, target);
      dfs(numbers, num-numbers[id], id+1, len, target);
    } else{
      if(num == target) answer++;
    }
  }

}
