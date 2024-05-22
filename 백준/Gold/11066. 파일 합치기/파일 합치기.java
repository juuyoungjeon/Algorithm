import java.util.*;
import java.io.*;

public class Main {
	static int K;
	static int[] book;
	static int[][] dp;
	static int min = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(br.readLine());
			
			book = new int[K+1];
			dp = new int[K+1][K+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i < K + 1; i++) {
				book[i] = book[i-1] + Integer.parseInt(st.nextToken());
			}
			
			for(int n = 1; n <= K; n++) {
				for(int from = 1; from + n <= K; from++) {
					int to = from + n;
					dp[from][to] = Integer.MAX_VALUE;
					for(int divide = from; divide < to; divide++) {
						dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide + 1][to] + book[to] - book[from - 1]);
					}
				}
			}
			
			sb.append(dp[1][K]).append("\n");
		}
		
		System.out.println(sb);
	}

}