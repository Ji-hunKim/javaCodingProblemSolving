package programmers;

class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        String k = "Kim";
        for(int i=0;i<seoul.length;i++){
            if(k.equals(seoul[i])) return "김서방은 "+i+"에 있다";
        }
        return answer;
    }
}