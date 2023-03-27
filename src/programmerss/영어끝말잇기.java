package programmers;

class Solution {
  public int[] solution(int n, String[] words) {
    int[] answer = {0,0};
    int temp1 = 0;

    for(int i=1;i<words.length;i++){
      String word = words[i];
      String prev = words[i-1];
      int plen = prev.length()-1;

      if(word.charAt(0) != prev.charAt(plen)){
        temp1 = i+1;
        break;
      }

      boolean check = false;
      for(int j = 0;j<i;j++){
        if(word.equals(words[j])){
          temp1 = i+1;
          check = true;
          break;
        }
      }
      if(check == true) break;
    }

    if(temp1 == 0) return answer;
    int first = temp1%n;
    int second = temp1/n;

    answer[0] = first == 0? n:first;
    answer[1] = first == 0? second:second+1;
    return answer;
  }
}
