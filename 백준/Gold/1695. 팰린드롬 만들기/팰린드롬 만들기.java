import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.println(solve(0, N - 1));
		
	}
	public static int solve(int left, int right) {
		if(left >= right) return 0;
		if(dp[left][right] != -1) return dp[left][right];
		dp[left][right] = 0;
		
		int min = 0;
		
		if(arr[left] == arr[right]) {
			min = solve(left + 1,right - 1);
		}else {
			min = Math.min(solve(left + 1, right) + 1, solve(left, right - 1) + 1);
		}
		
		return dp[left][right] = min;
	}

}