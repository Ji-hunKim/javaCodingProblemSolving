package leetcode;



class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        char now;
        char inStk;

        for(int i=0; i<s.length(); i++){
            now = s.charAt(i);

            if(stk.isEmpty() || now == '(' || now == '[' || now =='{'){
                stk.push(now);
            }else{
                inStk = stk.peek();
                if(inStk == '('){
                    if(now == ')'){
                        stk.pop();
                        continue;
                    }
                    return false;
                }

                if(inStk == '['){
                    if(now == ']'){
                        stk.pop();
                        continue;
                    }
                    return false;
                }

                if(inStk == '{'){
                    if(now == '}'){
                        stk.pop();
                        continue;
                    }
                    return false;
                }

                return false;
            }
        }
        if(!stk.isEmpty()) return false;
        return true;
    }
}