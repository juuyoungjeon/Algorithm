class Solution {
    static long[] dp = new long[2001]; 
    public long solution(int n) {
        long answer = 0;
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        
        answer = dp[n];
        return answer;
    }
    
    /*
    3
    1 1 1
    2 1
    1 2
    
    4
    1 1 1 1
    2 1 1
    1 2 1
    1 1 2
    2 2
    
    5
    1 1 1 1 1
    2 1 1 1
    1 2 1 1
    1 1 2 1
    1 1 1 2
    2 2 1
    2 1 2
    1 2 2
    
    
    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 3;
    dp[4] = 5;
    dp[5] = 8;
    */
}