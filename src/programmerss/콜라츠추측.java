package programmers;

class Solution {
    public int solution(int num) {
        if(num == 1) return 0;
        int i = 1;
        long num2 = num;
        while(i<500){
            num2 = calculator(num2);
            if (num2 == 1) return i;
            i += 1;
        }
        return -1;
    }
    
    public long calculator(long n){
        if(n%2 == 0) n = n/2;
        else n = n*3+1;
        return n;
    }
}
