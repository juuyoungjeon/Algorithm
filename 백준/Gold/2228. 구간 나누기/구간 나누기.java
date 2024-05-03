import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static boolean[][] visited;
	static int[] arr;
	static int[][] dp;
	static int Init = -32768*100;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1];
		
		for(int i = 1; i < N + 1; i++) {
			arr[i] = arr[i-1] + Integer.parseInt(br.readLine());
		}
		
		dp = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		for(int i = 0; i < N + 1; i++) {
			Arrays.fill(dp[i], Init);
		}
		
		System.out.println(solve(N,M));
	}
	static int solve(int idx, int section) {
		if(section == 0) return 0;
		if(idx < 0) return Init;
		
		if(visited[idx][section]) return dp[idx][section];
		
		visited[idx][section] = true;
		dp[idx][section] = solve(idx - 1, section);
		for(int i = idx; i > 0; i--) {
			dp[idx][section] = Math.max(dp[idx][section], solve(i-2, section-1) + (arr[idx]-arr[i-1]));
		}
		return dp[idx][section];
	}

}