import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] t;
	static int[][][][] dp;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		t = new int[N];

		dp = new int[N][10][10][10];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 10; j++) {
				for(int k = 0; k < 10; k++) {
					Arrays.fill(dp[i][j][k], -1);
				}
			}
		}
		
		System.out.println(recur(0,0,0,0));

	}
	public static int recur(int depth, int x, int y, int z) {
		if(depth == N) return 0;
		if(dp[depth][x][y][z] == -1) {
			dp[depth][x][y][z] = Integer.MAX_VALUE;
			dp[depth][x][y][z] = Math.min(dp[depth][x][y][z], recur(depth + 1, t[depth], y, z) + Math.min(Math.abs(x - t[depth]), 10 - Math.abs(x - t[depth])));
			dp[depth][x][y][z] = Math.min(dp[depth][x][y][z], recur(depth + 1, x, t[depth], z) + Math.min(Math.abs(y - t[depth]), 10 - Math.abs(y - t[depth])));
			dp[depth][x][y][z] = Math.min(dp[depth][x][y][z], recur(depth + 1, x, y, t[depth]) + Math.min(Math.abs(z - t[depth]), 10 - Math.abs(z - t[depth])));
		}
		
		return dp[depth][x][y][z];
	}

}