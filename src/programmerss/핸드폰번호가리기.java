package programmers;



import java.util.*;

class Solution {
    public String solution(String phone_number) {
        String[] list = String.valueOf(phone_number).split(""); 
        
        StringBuilder sb = new StringBuilder();
        int temp = 0;
		for (int i = (phone_number.length())-1; i>-1; i--){
            if(temp < 4) sb.append(list[i]);
            else sb.append("*");
            temp++;
        }   
        
        return sb.reverse().toString();
    }
    
    public String solution2(String phone_number) {
        char[] ch = phone_number.toCharArray();
        for(int i = 0; i < ch.length - 4; i ++){
            ch[i] = '*';
        }
        
        return String.valueOf(ch);
     }
}

