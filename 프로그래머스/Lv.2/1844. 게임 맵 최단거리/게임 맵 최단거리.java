import java.util.*;
import java.io.*;

class Solution {
    int answer = 0;
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    
    public int solution(int[][] maps) {
        int[][] visited = new int[maps.length][maps[0].length];
        bfs(maps, visited);
        
        answer = visited[maps.length-1][maps[0].length-1];
        if(answer == 0){
            answer = -1;
        }
        return answer;
    }
    public void bfs(int[][] maps, int[][] visited){
        int x = 0;
        int y = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        visited[x][y] = 1;
        
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            int nx = now[0];
            int ny = now[1];
            
            for(int i  = 0; i < 4; i++){
                int nextX = nx + dx[i];
                int nextY = ny + dy[i];
                
                if(nextX < 0 || nextX > maps.length - 1 || nextY < 0 || nextY > maps[0].length - 1) continue;
                
                if(visited[nextX][nextY] == 0 && maps[nextX][nextY] == 1){
                    
                    visited[nextX][nextY] = visited[nx][ny] + 1;
                    q.add(new int[]{nextX,nextY});
                }
                 
                
            }
            
        }
    }
}