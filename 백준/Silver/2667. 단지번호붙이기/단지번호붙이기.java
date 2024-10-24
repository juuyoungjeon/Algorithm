import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static boolean[][] visited;
	static int cnt;
	static int ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
//					visited[i][j] = true;
					cnt++;
					ans = 0;
					dfs(i,j);
					list.add(ans);
				}
			}
		}
		
		Collections.sort(list);
		
		sb.append(cnt + "\n");
		for(int i : list) {
			sb.append(i).append("\n");
		}
		
		System.out.println(sb);
		
	}
	public static void dfs(int x, int y) {
		visited[x][y] = true;
//		ans = Math.max(ans, sum);
		ans++;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
			
			if(visited[nx][ny] || map[nx][ny] == 0) continue;
			
			visited[nx][ny] = true;
			map[nx][ny] += map[x][y];
			
			dfs(nx, ny);
		}
	}

}