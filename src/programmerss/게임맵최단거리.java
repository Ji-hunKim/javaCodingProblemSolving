package programmers;

import java.util.*;

class Solution {

  int[] dx = {0,0,1,-1};
  int[] dy = {1,-1,0,0};

  int[][] visited;

  int N,M;

  int answer = 0;

  public int solution(int[][] maps) {

    N = maps.length;
    M = maps[0].length;

    visited = new int[N][M];

    Queue<Node> queue = new LinkedList<>();

    queue.offer(new Node(0,0,1));
    visited[0][0] = 1;

    while(!queue.isEmpty()){
      Node now = queue.poll();

      for(int i=0; i<4; i++){
        int nx = now.x + dx[i];
        int ny = now.y + dy[i];

        if(nx <0 || ny <0 || nx>=N || ny>=M) continue;

        if(visited[nx][ny] != 0) continue;

        if(maps[nx][ny] == 0) continue;

        queue.offer(new Node(nx,ny,now.val+1));
        visited[nx][ny] = now.val+1;
      }
    }

    if(visited[N-1][M-1] == 0) answer = -1;
    else answer = visited[N-1][M-1];

    return answer;
  }

  public class Node {
    int x;
    int y;
    int val;

    public Node(int x, int y, int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }
  }
}}