import java.util.*;
import java.io.*;

public class Main {
	static int A, B, C;
	static char[] arr1;
	static char[] arr2;
	static int[][] dp;
	static final int INF = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr1 = br.readLine().toCharArray();
		arr2 = br.readLine().toCharArray();
		
		dp = new int[3000][3000];
		
		for(int i = 0; i < 3000; i++) {
			for(int j = 0; j < 3000; j++) {
				dp[i][j] = INF;
			}
		}
		
		System.out.println(solve(0,0));
	}
	public static int solve(int N, int M) {
		if(N == arr1.length) return (arr2.length - M) * B;
		if(M == arr2.length) return (arr1.length - N) * B;
		
		if(dp[N][M] != INF) return dp[N][M];
		dp[N][M] = 0;
		
		dp[N][M] = B + Math.max(solve(N+1, M), solve(N, M + 1));
		dp[N][M] = Math.max(dp[N][M], (arr1[N] == arr2[M] ? A : C) + solve(N+1, M+1));
		
		return dp[N][M];
	}

}