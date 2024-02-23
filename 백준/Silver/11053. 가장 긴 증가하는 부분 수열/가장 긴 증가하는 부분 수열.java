import java.util.*;
import java.io.*;

public class Main {
	static int N, ans, now;
	static int[] arr, dp;
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
		
		dp = new int[N];
		
		Arrays.fill(dp, -1);
		for(int i = 0; i < N; i++) {
			LIS(i);
		}
		
		ans = dp[0];
		
		for(int i = 1; i < N; i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
		
		
	}
	public static int LIS(int N) {
		if (dp[N] == -1) {
			dp[N] = 1;
			
			for(int i = N - 1; i >= 0; i--) {
				if(arr[i] < arr[N]) {
					dp[N] = Math.max(dp[N], LIS(i) + 1);
				}
			}
		}
		return dp[N];
	}
}