package programmers;

class Solution {
  public int solution(int m, int n, String[] board) {
    int answer = 0;
    boolean[][] ch = new boolean[m][n];
    char[][] boardd = new char[m][n];

    for(int i=0; i<m; i++){
      for(int j=0; j<n; j++){
        boardd[i][j] = board[i].charAt(j);
      }
    }

    while(true){
      int temp = answer;

      for(int i=0; i<m-1; i++){
        for(int j=0; j<n-1; j++){
          if(boardd[i][j] == boardd[i][j+1] &&
                  boardd[i][j] == boardd[i+1][j] &&
                  boardd[i][j] == boardd[i+1][j+1] &&
                  boardd[i][j] != '0'){
            ch[i][j] = true;
            ch[i][j+1] = true;
            ch[i+1][j] = true;
            ch[i+1][j+1] = true;
          }
        }
      }

      for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
          if(ch[i][j]){
            answer++;
            boardd[i][j] = '0';
          }
        }
      }
      if(temp == answer) break;

      boolean[][] bt = new boolean[m][n];
      ch = bt;

      for(int k=0; k<m-1; k++){
        for(int i=1; i<m; i++){
          for(int j=0; j<n; j++){
            if(boardd[i][j] == '0'){
              boardd[i][j] = boardd[i-1][j];
              boardd[i-1][j] = '0';
            }
          }
        }
      }

    }
    return answer;
  }
}