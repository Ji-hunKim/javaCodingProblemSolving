package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단지번호붙이기 {
  static int n;
  private static int dx[] = {0,0,1,-1};
  private static int dy[] = {1,-1,0,0};
  private static int[] aparts = new int[25*25];
  private static int[][] map;
  private static int apartNum;
  private static boolean[][] visited = new boolean[25][25];;



  public static void main(String[] args) throws IOException {
    // input
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    n = Integer.parseInt(s);
    map = new int[n][n];


    for (int i = 0; i < n; i++) {
      s = br.readLine();
      for(int j=0; j<n; j++) {
        map[i][j] = (int)s.charAt(j) - '0';
      }
    }

    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        if(map[i][j] == 1 && !visited[i][j]){
          apartNum++;
          dfs(i,j);
        }
      }
    }

    Arrays.sort(aparts);
    System.out.println(apartNum);

    for(int i=0; i<aparts.length; i++){
      if(aparts[i] == 0){
      }else{
        System.out.println(aparts[i]);
      }
    }
  }

  private static void dfs(int x, int y) {
    visited[x][y] = true;
    aparts[apartNum]++;

    for(int i=0; i<4; i++){
      int nx = x + dx[i];
      int ny = y + dy[i];

      if(nx >=0 && ny >=0 && nx < n && ny < n){
        if(map[nx][ny] == 1 && !visited[nx][ny]){
          dfs(nx,ny);
        }
      }
    }
  }
}
