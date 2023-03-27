package programmers;

class Solution {
    public String solution(String s) {
        String answer = "";
        int sLen = s.length();

        if(sLen%2 == 0){
            answer += s.substring(sLen/2-1, sLen/2+1);
            return answer;
        }
        else{
            answer += s.substring(sLen/2, sLen/2+1);
            return answer;
        }
    }
}
