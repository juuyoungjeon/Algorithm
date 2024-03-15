import java.util.*;
import java.io.*;

public class Main {
	
	static int M, N;
	static int ans;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<int []> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());//열
		N = Integer.parseInt(st.nextToken());//행
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					q.add(new int[] {i, j});
				}
			}
		}
		System.out.println(bfs());
	}
	
	private static int bfs() {
		while(!q.isEmpty()) {
			int[] t = q.poll();
			int x = t[0];
			int y = t[1];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx < 0 || nx >= N || ny < 0|| ny >= M) continue;
				if(map[nx][ny] == 0) {
					map[nx][ny] = map[x][y] + 1;
					q.add(new int[] {nx, ny});
				}
			}
		}
		ans = Integer.MIN_VALUE;
		if(check()) {
			return -1;
		}else {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					ans = Math.max(ans, map[i][j]);
				}
			}
		}
		return ans-1;
	}

	private static boolean check() {

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0)
					return true;
			}
		}
		return false;
	}
	
}