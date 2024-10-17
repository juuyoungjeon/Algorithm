import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int[][] dp;
	static int ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[202][202];
		
		for(int[] i : dp) {
			Arrays.fill(i, -1);
		}
		
		System.out.println(solve(N, K));
		
	}
	public static int solve(int sum, int depth) {
		if(depth == 0) {
			if(sum == 0) 
				return 1;
			else
				return 0;
		}
		
		if(sum < 0) return 0;
		
		if(dp[sum][depth] != -1) return dp[sum][depth];
		
		dp[sum][depth] = (solve(sum, depth - 1) + solve(sum - 1, depth)) % 1000000000;
		
		return dp[sum][depth];
	}

}