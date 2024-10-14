import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	static int[][] dp;
	static int max;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][N];
		
		dp = new int[N][N];
		for(int[] i : dp) {
			Arrays.fill(i, -1);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				max = Math.max(max, solve(i,j));
			}
		}
		
		System.out.println(max);
	}

	public static int solve(int x, int y) {
		if(dp[x][y] != -1) return dp[x][y];
		
		dp[x][y] = 1;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && map[nx][ny] > map[x][y]) {
				visited[nx][ny] = true;
				dp[x][y] = Math.max(dp[x][y], solve(nx, ny) + 1);
				visited[nx][ny] = false;
			}
		}
		
		return dp[x][y];
	}
}