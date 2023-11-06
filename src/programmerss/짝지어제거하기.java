package programmerss;

import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack<Character> stk = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char now = s.charAt(i);

            if(stk.size() == 0) {
                stk.push(now);
                continue;
            }

            char peek = stk.peek();

            if(peek == now){
                stk.pop();
            }else{
                stk.push(now);
            }
        }

        if(stk.size() == 0) answer = 1;
        else answer = 0;

        return answer;
    }
}