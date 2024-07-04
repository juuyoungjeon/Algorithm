import java.util.*;
import java.io.*;

public class Main {
	static int N, T;
	static int[] time, score;
	static int max = Integer.MIN_VALUE;
	static Integer[][] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		dp = new Integer[N][T+1];
		
		time = new int[N];
		score = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			score[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(knapsack(N-1,T));
		
	}
	public static int knapsack(int i, int s) {
		if(i < 0) {
			return 0;
		}
		if(dp[i][s] == null) {
			if(time[i] > s) {
				return dp[i][s] = knapsack(i-1,s);
			}else {
				dp[i][s] = Math.max(knapsack(i-1,s), knapsack(i-1, s - time[i]) + score[i]);
			}
		}
		return dp[i][s];
	}

}