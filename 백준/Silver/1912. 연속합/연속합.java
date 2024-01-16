import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] =  Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N + 1];
		dp[1] = arr[1];
		for(int i = 2; i <= N; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i <= N; i++) {
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}

}