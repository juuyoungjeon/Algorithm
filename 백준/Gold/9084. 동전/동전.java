import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] coin;
	static int M;
	static boolean[] visited;
	static int[] dp;
	static int cnt;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			coin = new int[N + 1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i <= N; i++) {
				coin[i] = Integer.parseInt(st.nextToken());
			}
			
			M = Integer.parseInt(br.readLine());
			dp = new int[M + 1];
			dp[0] = 1;
			
			for(int i = 1; i <= N; i++) {
				for(int j = coin[i]; j <= M; j++) {
					dp[j] += dp[j-coin[i]];
				}
			}
			sb.append(dp[M] + "\n");
		}
		
		System.out.println(sb);
	}
	

}