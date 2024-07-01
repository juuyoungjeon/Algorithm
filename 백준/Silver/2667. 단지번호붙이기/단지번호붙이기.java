import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int num;
	static int cnt;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];
		list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					cnt = 0;
					num++;
					dfs(i,j);
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		sb.append(num).append("\n");
		for(int i : list) {
			sb.append(i + "\n");
		}
		
		System.out.println(sb);
		
	}
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		map[x][y] = num;
		cnt++;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
			if(map[nx][ny] == 0) continue;
			visited[nx][ny] = true;
			map[nx][ny] = num;
			dfs(nx, ny);
		}
	}

}