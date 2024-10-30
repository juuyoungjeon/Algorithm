import java.util.*;

class Solution {
    static int answer;
    static boolean[] visited;
    static int n;
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        
        visited = new boolean[n];
        dfs(0, k, dungeons);
        
        return answer;
    }
    public static void dfs(int depth, int k, int[][] dungeons){
        for(int i = 0; i < n; i++){
            if(!visited[i] && dungeons[i][0] <= k){
                visited[i] = true;
                dfs(depth + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        
        answer = Math.max(answer, depth);
    }
}