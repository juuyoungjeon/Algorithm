import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int ans = -1;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[100001];
		
		dp[0] = INF;
		dp[1] = INF;
		dp[2] = 1;
		dp[3] = INF;
		dp[4] = 2;
		dp[5] = 1;
		
		for(int i = 6; i <= n; i++) {
			dp[i] = Math.min(dp[i-2], dp[i-5]) + 1;
		}
		
		System.out.println(dp[n] == INF ? -1 : dp[n]);
	}
	

}