import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;
	static int max;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		int[] dp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		max = arr[0];
		
		for(int i = 1; i < N; i++) {
			dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}