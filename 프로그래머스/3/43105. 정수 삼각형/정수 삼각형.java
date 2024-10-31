import java.util.*;

class Solution {
    static int[][] dp;
    static int[] dCol = {0,1};
    static int n, m;
    static int ret;
    public int solution(int[][] triangle) {
        int answer = 0;
        n = triangle.length;
        m = triangle.length;
        dp = new int[triangle.length + 1][triangle.length + 1];
        
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        
        answer = solve(0,0,triangle);
        
        return answer;
    }
    public static int solve(int x, int y, int[][] triangle){
        if(x >= n - 1) {
            dp[x][y] = triangle[x][y];
            return dp[x][y];
        }
        if(dp[x][y] != -1) return dp[x][y];
        
        dp[x][y] = 0;
        ret = 0;
        
        for(int i=0;i<2;i++){
            int newRow = x+1;
            int newCol = y + dCol[i];
            if(0<=newCol && newCol<triangle[newRow].length){
                ret = Math.max(ret, solve(newRow,newCol,triangle) + triangle[x][y]); //아래로 뻗쳐나가는 가지 중에서 가장 최댓값을 취해야 하므로 max연산을 해줌, 가지값+내꺼랑 비교한당
            }
        }
        
        dp[x][y] = ret;
        return dp[x][y];
    }
}