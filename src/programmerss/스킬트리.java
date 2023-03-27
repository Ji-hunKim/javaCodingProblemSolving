package programmers;

class Solution {
  public int solution(String skill, String[] skill_trees) {
    int answer = 0;

    for(String skt : skill_trees){
      int k=0;
      boolean ch=true;

      for(int i=0; i<skt.length(); i++){
        if(k >= skill.length()){
          answer++;
          ch = false;
          break;
        }else if(skt.charAt(i) != skill.charAt(k)){
          if(skill.contains(String.valueOf(skt.charAt(i)))){
            ch = false;
            break;
          }
        }else{
          k++;
        }
      }
      if(ch) answer++;

    }
    return answer;
  }
}
