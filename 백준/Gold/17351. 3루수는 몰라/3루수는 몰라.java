import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static char[][] map;
	static int[] dx = {1,0};
	static int[] dy = {0,1};
	static int[][][] dp = new int[505][505][4];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for(int i = 0; i < 505; i++) {
			for(int j = 0; j < 505; j++) {
				for(int k = 0; k < 4; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		
		if(map[0][0] == 'M') {
			System.out.println(solve(0,0,1));
		}else {
			System.out.println(solve(0,0,0));
		}
	}
	public static int solve(int x, int y, int str) {
		if(x == N-1 && y == N-1) {
			return 0;
		}
		
		if(dp[x][y][str] != -1) return dp[x][y][str];
		dp[x][y][str] = 0;
		
		
		for(int i = 0; i < 2; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx > N-1 || ny < 0 || ny > N-1) continue;
			
			if(map[nx][ny] == 'M') {
				dp[x][y][str] = Math.max(dp[x][y][str], solve(nx,ny,1));
			}else if(map[nx][ny] == 'O' && str == 1) {
				dp[x][y][str] = Math.max(dp[x][y][str], solve(nx,ny,2));
			}else if(map[nx][ny] == 'L' && str == 2) {
				dp[x][y][str] = Math.max(dp[x][y][str], solve(nx,ny,3));
			}else if(map[nx][ny] == 'A' && str == 3) {
				dp[x][y][str] = Math.max(dp[x][y][str], solve(nx,ny,0) + 1);
			}else {
				dp[x][y][str] = Math.max(dp[x][y][str], solve(nx,ny,0));
			}
			
		}
		return dp[x][y][str];
	}

}