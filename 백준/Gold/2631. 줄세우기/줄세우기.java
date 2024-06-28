import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static int[] dp;
	static int ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		dp = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			dp[i] = 1;
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		
		System.out.println(N - ans);
	}

}