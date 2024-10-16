import java.util.*;
import java.io.*;

public class Main {

	static int M, N;
	static int[][] map, dp;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M+1][N+1];
		dp = new int[M+1][N+1];
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(1,1));
		
	}

	private static int dfs(int x, int y) {
		if(x == M && y == N) {
			return 1;
		}
		if(dp[x][y] != -1) {
			return dp[x][y];
		}else {
			dp[x][y] = 0;
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 1 || ny < 1 || nx > M || ny > N) continue;
				
				if(map[x][y] > map[nx][ny]) {
					dp[x][y] += dfs(nx,ny);
				}
			}
		}
		return dp[x][y];
	}

}