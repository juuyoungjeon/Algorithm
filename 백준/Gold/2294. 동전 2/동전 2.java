import java.util.*;
import java.io.*;

public class Main {
	static int n, k;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		
		arr = new int[n];
		dp = new int[k+1];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.fill(dp, -1);
		
		int res = solve(k);
		System.out.println(res == 987654321 ? -1 : res);
		
	}
	public static int solve(int sum) {
		if(sum == 0) return 0;
		
		if(sum < 0) return 987654321;
		
		if(dp[sum] != -1) return dp[sum];
		
		int ret = 987654321;
		
		for(int i = 0; i < n; i++) {
			ret = Math.min(ret, solve(sum - arr[i]) + 1);
		}
		
		return dp[sum] = ret;
	}

}