import java.util.*;
import java.io.*;

public class Main {
	static int N, K;
	static char[][] map;
	static int[] dx = {0,1};
	static int[] dy = {1,0};
	static boolean[][] visited;
	static int[][][][] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new char[N][N];
			visited = new boolean[N][N];

			for(int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			dp = new int[60][60][4][5];
			
			for(int i = 0; i < 60; i++) {
				for(int j = 0; j < 60; j++) {
					for(int k = 0; k < 4; k++) {
						for(int l = 0; l < 5; l++) {
							dp[i][j][k][l] = -1;
						}
					}
				}
			}
//			sb.append(map[1][1]).append("\n");
			sb.append(recur(0,0,3,0)).append("\n");
		}
		
		System.out.println(sb);

	}
	public static int recur(int x, int y, int prev, int cnt) {
		if(x == N - 1 && y == N - 1) return 1;
		
		if(dp[x][y][prev][cnt] != -1) return dp[x][y][prev][cnt];
		
		int ret = 0;
		
		if(cnt <= K) {
			for(int i = 0; i < 2; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= N || ny >= N) continue;
				
				if(map[nx][ny] == 'H') continue;
				
				if(prev == i) ret += recur(nx, ny, i, cnt);
				else ret += recur(nx, ny, i, cnt + 1);
			}
		}
		else {
			int nx = x + dx[prev];
			int ny = y + dy[prev];
			
			if(nx < N && ny < N && map[nx][ny] == '.') {
				ret += recur(nx, ny, prev, cnt);
			}
		}
		
		dp[x][y][prev][cnt] = ret;
		
		return ret;
		
	}
//	public static int dfs(int x, int y, int prev, int cnt) {
//		if(x < 0 || x >= N || y < 0 || y >= N) return 0;
//		if(visited[x][y]) return 0;
//		if(map[x][y] == 'H') return 0;
//		if(cnt > K) return 0;
//
//		if(cnt == K) {
//			if(x == N - 1 && y == N - 1) {
//				return 1;
//			}else {
//				return 0;
//			}
//
//			if(move(x,y,prev,cnt)) {
//				return 0;
//			}
//
//			//아래로 가면 0, 오른쪽으로 가면 1
//			for(int i = 0; i < 2; i++) {
//				if(i == prev) {
//					dfs(x + dx[i], y, i, cnt);
//					dfs(x, y + dy[i], i, cnt);
//				}else {
//					dfs(x + dx[i], y, i, cnt + 1);
//					dfs(x, y + dy[i], i, cnt + 1);
//				}
//			}
//			return 0;
//
//		}
//
//	}


}