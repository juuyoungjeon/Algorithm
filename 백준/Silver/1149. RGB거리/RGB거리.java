import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map, dp;
	static int min = Integer.MAX_VALUE;
	static int ret = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][4];
		dp = new int[N][4];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(solve(0,3));
	}
	public static int solve(int cur, int prev) {
		if(cur == N) {
			return 0;
		}
		if(dp[cur][prev] != -1) return dp[cur][prev];
		
		ret = Integer.MAX_VALUE;

		for(int i = 0; i < 3; i++) {
			if(i == prev) continue;
			ret = Math.min(ret, solve(cur + 1, i) + map[cur][i]);
		}

		dp[cur][prev] = ret;
		return dp[cur][prev];
	}

}