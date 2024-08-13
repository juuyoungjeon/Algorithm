import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int max = Integer.MIN_VALUE;
	static char[] arr;
	static int[][][] dp;
	static char[] c = {'B','L','D'};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = br.readLine().toCharArray();

		//BLD
		dp = new int[3*N][3*N][3];
		for(int i = 0; i < 3*N; i++) {
			for(int j = 0; j < 3*N; j++) {
				for(int k = 0; k < 3; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		System.out.println(solve(0,3*N-1,0));
	}
	public static int solve(int front, int end, int time) {
		if(front > end) return 0;
		//앞뒤,
		if(dp[front][end][time] != -1) return dp[front][end][time];
		dp[front][end][time] = 0;

		if(arr[front] == c[time]) dp[front][end][time] = Math.max(dp[front][end][time], solve(front + 1, end, time==2? 0 : time + 1) + 1);
		if(arr[end] == c[time]) dp[front][end][time] = Math.max(dp[front][end][time], solve(front, end - 1, time==2? 0 : time + 1) + 1);
		return dp[front][end][time];
	}

}