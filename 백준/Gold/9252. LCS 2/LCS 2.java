import java.util.*;
import java.io.*;

public class Main {
	static char[] first, second;
	static int[][] dp;
	static StringBuilder sb = new StringBuilder();
	static Stack<Character> stack = new Stack<>();
	static int N, M;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		first = s.toCharArray();
		
		String s2 = br.readLine();
		second = s2.toCharArray();
		
		N = s.length();
		M = s2.length();
		dp = new int[N + 1][M + 1];
		
		int ans = getLCSLength();
		sb.append(ans).append("\n");
		
		
		while(N != 0 && M != 0) {
			if(first[N-1] == second[M-1]) {
//				sb.append(first[N-1]);
				stack.add(first[N-1]);
				N--;
				M--;
			}else if(dp[N][M] == dp[N-1][M]) {
				N--;
			}else if(dp[N][M] == dp[N][M-1]) {
				M--;
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
	public static int getLCSLength() {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(first[i-1] == second[j-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[N][M];
	}

}