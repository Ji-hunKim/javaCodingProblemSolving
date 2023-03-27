package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 전쟁전투 {
  static int n,m;
  private static int dx[] = {0,0,1,-1};
  private static int dy[] = {1,-1,0,0};
  private static char[][] map;
  private static int count;
  private static int wcount;
  private static int bcount;
  private static boolean[][] visited;



  public static void main(String[] args) throws IOException {
    // input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    StringTokenizer st = new StringTokenizer(s, " ");

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    map = new char[m][n];
    visited = new boolean[m][n];;


    for (int i=0; i<m; i++) {
      s = br.readLine();
      for(int j=0; j<n; j++) {
        map[i][j] = s.charAt(j);
      }
    }

    for(int i=0; i<m; i++){
      for(int j=0; j<n; j++){
        if(!visited[i][j]){
          char color = map[i][j];
          count = 0;
          dfs(i,j,color);

          if(color == 'W') {
            wcount += count * count;
          }
          else {
            bcount += count * count;
          }
        }
      }
    }

    System.out.println(wcount+" "+bcount);
  }

  private static void dfs(int x, int y, char color) {
    visited[x][y] = true;
    count++;

    for(int i=0; i<4; i++){
      int nx = x + dx[i];
      int ny = y + dy[i];

      if(nx >=0 && ny >=0 && nx < m && ny < n){
        if(map[nx][ny] == color && !visited[nx][ny]){
          dfs(nx,ny,color);
        }
      }
    }
  }
}

