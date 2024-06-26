import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int max = Integer.MIN_VALUE;
	static int[][] dx = {{0,1}, {0,1}, {-1,0}, {-1,0}};
	static int[][] dy = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0,0);
		System.out.println(max);
	}
	public static void solve(int tmp, int sum) {
		if(tmp == N*M) {
			max = Math.max(max, sum);
			return;
		}
		int x = tmp / M;
		int y = tmp % M;

		if(!visited[x][y]) {
			for(int i = 0; i < 4; i++) {
				int x1 = x + dx[i][0];
				int y1 = y + dy[i][0];
				int x2 = x + dx[i][1];
				int y2 = y + dy[i][1];

				if(isPossible(x1,x2,y1,y2)) {
					visited[x][y] = true;
					visited[x1][y1] = true;
					visited[x2][y2] = true;
					solve(tmp + 1, sum + (map[x][y]*2) + map[x1][y1] + map[x2][y2]);
					visited[x][y] = false;
					visited[x1][y1] = false;
					visited[x2][y2] = false;
				}
			}
		}
		solve(tmp+1, sum);

	}
	public static boolean isPossible(int x1, int x2, int y1, int y2) {
		if(x1 < 0 || x1 >= N || y1 < 0 || y1 >= M) return false;
		if(x2 < 0 || x2 >= N || y2 < 0 || y2 >= M) return false;
		if(visited[x1][y1]) return false;
		if(visited[x2][y2]) return false;
		return true;
	}
}