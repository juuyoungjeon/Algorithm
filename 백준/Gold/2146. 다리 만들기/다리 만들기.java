import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	static int ans, num;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean[][] visited;
	static int cnt;
	static Queue<int []> q;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] != 0) {
					num++;
					dfs(i,j);
				}
			}
		}

		ans = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] != 0) {
					visited = new boolean[N][N];
					int res = length(i,j);
					if(res == -1) continue;
					ans = Math.min(ans, res);
				}
			}
		}
		
		System.out.println(ans - 1);
	}
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		map[x][y] = num;

		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if(nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) continue;
			if(visited[nx][ny] || map[nx][ny] == 0) continue;
			dfs(nx,ny);
		}
	}

	public static int length(int x, int y) {
		q = new LinkedList<>();
		
		int num = map[x][y];
		visited[x][y] = true;
		q.add(new int[] {x,y,0});
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int px = pos[0];
			int py = pos[1];
			int length = pos[2];
			
			if(map[px][py] != 0 && map[px][py] != num) {
				return length;
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = px + dx[i];
				int ny = py + dy[i];
				
				if(nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) continue;
				if(visited[nx][ny] || map[nx][ny] == num) continue;
				
				visited[nx][ny] = true;
				q.add(new int[] {nx,ny,length+1});
				
			}
		}
		return -1;
	}
}