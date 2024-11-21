import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static int[] dp;
	static int ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		dp = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[1] = arr[1];
		
		System.out.println(dfs(N));
		
//		System.out.println(topDown(N));
	}
	public static int dfs(int cur) {
		if(cur == 0) return 0;
		if(dp[cur] > 0) return dp[cur];
		
		dp[cur] = arr[cur];
		for(int i = 1; i <= cur; i++) {
			dp[cur] = Math.max(dp[cur], dfs(cur - i) + arr[i]);
		}
		
		return dp[cur];
	}
	
	public static int topDown(int n){
        if(dp[n] > 0) return dp[n];     // 값이 이미 있었다면 바로 반환
        
        int temp = arr[n]; // 비교 전 최초에는 n개 짜리로 지정
        for(int i=1; i <= n; i++){
            int current = topDown(n-i) + arr[i];
            temp = Math.max(temp, current);
        }
        return dp[n] = temp;
    }

}