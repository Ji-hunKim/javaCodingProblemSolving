package programmers;

class Solution {
    public boolean solution(int x) {
        String str = String.valueOf(x);
        int temp = 0;
        for(int i=0; i<str.length(); i++){
            temp += str.charAt(i)-'0';
        }
        if(x % temp == 0) return true;
        else return false;
    }
}

/*
 * int sum = 0; int a = x;
 * 
 * while (a >= 1) { sum += a % 10; a /= 10; }
 * 
 * if (x % sum == 0) return true; 
 * else return false;
 */