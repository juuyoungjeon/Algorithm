import java.util.*;

class Solution {
    static int n,m;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0, -1, 0, 1};
    public int solution(int[][] maps) {
        int answer = 0;
        
        
        n = maps.length;
        m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        bfs(maps, visited);
        
        answer = maps[n-1][m-1];
        
        if(!visited[n-1][m-1]){
            answer = -1;
        }
        
        return answer;
    }
    public static void bfs(int[][] maps, boolean[][] visited){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(visited[nx][ny] || maps[nx][ny] == 0) continue;
                
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
                
                maps[nx][ny] = maps[x][y] + 1;
            }
        }
    }
}