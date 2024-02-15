import java.util.*;
import java.io.*;

public class Main {
	static int N, cnt;
	static long[][][ ]dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true) {
			N = Integer.parseInt(br.readLine());
			
			if(N==0) break;

			cnt = 0;
			dp = new long[2*N+1][N+1][N+1];

			for(int i = 0 ; i <= 2*N; i++) {
				for(int j = 0 ; j<= N ;j++) {
					Arrays.fill(dp[i][j],-1);
				}
			}

			long ans = solve(0, N, 0);
			sb.append(ans).append("\n");
//			System.out.println(ans);
		}
		System.out.println(sb);
	}

	public static long solve(int depth, int w, int h) {
		if(depth == 2*N) {
			cnt++;
			return 1;
		}
		if(dp[depth][w][h] != -1) {
			return dp[depth][w][h];
		}

		long sum = 0;
		if(w > 0) {//이때 한개짜리 먹는다
			sum += solve(depth + 1, w - 1, h + 1);
		}

		if(h > 0) {//이때 반개 짜리 먹음
			sum += solve(depth + 1, w, h - 1);
		}

		dp[depth][w][h] = sum;
		return dp[depth][w][h] ;
	}
}