package programmerss;

class 정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;

        for(int i=1; i<len; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(j == 0){
                    triangle[i][j] += triangle[i-1][0];
                }else if(j == triangle[i].length-1){
                    triangle[i][j] += triangle[i-1][triangle[i-1].length-1];
                }else{
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
            }
        }

        answer = triangle[len-1][0];

        for(int i=1; i<triangle[len-1].length; i++){
            answer = Math.max(answer, triangle[len-1][i]);
        }
        return answer;
    }
}