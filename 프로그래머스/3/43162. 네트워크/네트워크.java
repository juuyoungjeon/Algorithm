import java.util.*;
import java.io.*;

class Solution {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static int cnt;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        list = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }
        
        visited = new boolean[n+1];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j && computers[i][j] == 1) {         
                    list.get(i+1).add(j+1);
                    list.get(j+1).add(i+1);
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                bfs(i);
                answer++;
            }
        }
        
        
        return answer;
    }
    
    public static void bfs(int idx){
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        visited[idx] = true;
        
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int next : list.get(now)){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}