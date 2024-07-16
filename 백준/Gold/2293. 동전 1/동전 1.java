import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		dp = new int[N+1][K+1];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 0; i <= N; i++) {
			Arrays.fill(dp[i], -1);
			
		}
		System.out.println(dfs(N,K));
	}
	public static int dfs(int idx, int cost) {
		if(cost == 0) return 1;
		if(idx <= 0 || cost < 0) return 0;
		
		if(dp[idx][cost] != -1) return dp[idx][cost];
		
		dp[idx][cost] = dfs(idx, cost - arr[idx-1]) + dfs(idx-1,cost);

		return dp[idx][cost];
		
	}

}