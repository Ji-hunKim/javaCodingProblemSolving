package programmers;

public class Solution {	//약수의 개수와 덧셈 
	public int solution(int left, int right) {
        int answer = 0;
        for(int i = left;i<right+1;i++){
            int temp = 0;
            for(int j=1;j<i+1;j++){
                if(i%j == 0){
                    temp++;
                }
            }
            if(temp%2 == 0){
                answer += i;
            }
            else{
                answer -= i;
            }
        }
        return answer;
    }
}
