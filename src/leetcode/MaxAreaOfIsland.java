package leetcode;

class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};

    boolean[][] visited;
    int[][] maps;

    int maxVal = 0;
    int temp;

    int lenx,leny;


    public int maxAreaOfIsland(int[][] grid) {
        lenx = grid.length;
        leny = grid[0].length;

        visited = new boolean[lenx][leny];
        maps = new int[lenx][leny];

        for(int i=0; i<lenx; i++){
            for(int j=0; j<leny; j++){
                maps[i][j] = grid[i][j];
            }
        }

        for(int i=0; i<lenx; i++){
            for(int j=0; j<leny; j++){
                if(!visited[i][j] && maps[i][j] == 1){
                    temp = 0;
                    dfs(i,j);
                    if(temp > maxVal) maxVal = temp;
                }

            }
        }
        return maxVal;
    }

    public void dfs(int x, int y){
        temp++;
        visited[x][y] = true;
        int nx,ny;

        for(int i=0; i<4; i++){
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=lenx || ny>=leny) continue;

            if(visited[nx][ny]) continue;

            if(maps[nx][ny] == 0) continue;

            dfs(nx,ny);
        }
    }
}