import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1];
		dp = new int[N+1][N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int[] i : dp) {
			Arrays.fill(i, -1);
		}
		
		M = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			if(solve(s,e) == 1) {
				sb.append("1\n");
			}else {
				sb.append("0\n");
			}
			
		}
		System.out.println(sb);
		
		
	}
	public static int solve(int left, int right) {
		if(left >= right) return 1;
		
		if(dp[left][right] != -1) return dp[left][right];
		
		if(arr[left] == arr[right]) {
			return dp[left][right] = solve(left + 1, right - 1);
		}
		
		return 0;
	}

}