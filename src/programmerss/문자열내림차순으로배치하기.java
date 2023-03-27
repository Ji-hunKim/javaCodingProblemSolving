package programmers;

import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] chararr = s.toCharArray();
        Arrays.sort(chararr);
        
        String newStr = String.valueOf(chararr);
        
        StringBuilder sb = new StringBuilder(newStr);
        answer = sb.reverse().toString();
        return answer;
        
    }
}