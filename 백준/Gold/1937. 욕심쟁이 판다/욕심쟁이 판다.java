import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] map;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		dp = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				ans = Math.max(ans, DFS(i,j));
			}
		}
		System.out.println(ans);
	}

	private static int DFS(int x, int y) {
		// TODO Auto-generated method stub
		if(dp[x][y] != 0) {
			return dp[x][y];
		}
		
		dp[x][y] = 1;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
				continue;
			}
			
			if(map[x][y] < map[nx][ny]) {
				dp[x][y] = Math.max(dp[x][y], DFS(nx, ny) + 1);
				DFS(nx, ny);
			}
		}
		return dp[x][y];
	}

}
