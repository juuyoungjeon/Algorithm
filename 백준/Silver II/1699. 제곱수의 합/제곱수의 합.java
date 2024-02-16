import java.util.*;
import java.io.*;

public class Main {
	static int N, ans;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N + 1];
//		 dp[0] = 0;
//		 dp[1] = 1;
//		 dp[2] = 2;
//		 dp[3] = 3;
		
		 ans = 0;
//		 solve(0, 0, 1);
		 dfs(N);
		 System.out.println(dp[N]);
	}
	
//	public static void solve(int cnt, int sum, int start) {
//		if(sum == N) {
//			return;
//		}
//		
//		for(int i = start; i <= Math.sqrt(N); i++) {
//			dp[start] = i*i;
//			solve(cnt + 1, sum + dp[start], start + 1);
//		}
//	}
	public static void dfs(int num) {
		dp[1] = 1;
		
		for(int i = 2; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			for(int j = 1; j <= i/2; j++) {
				if(j*j == i) {
					min = 1;
					break;
				}else {
					min = Math.min(min, dp[j] + dp[i-j]); 
				}
			}
			dp[i] = min;
		}
		return;
	}

}