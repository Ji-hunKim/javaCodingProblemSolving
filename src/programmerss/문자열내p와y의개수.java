package programmers;

class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        int temp = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'p' ) temp +=1;
            else if(s.charAt(i) == 'y') temp -= 1;
        }
        if(temp == 0) return true;
        else return false;
    }
}