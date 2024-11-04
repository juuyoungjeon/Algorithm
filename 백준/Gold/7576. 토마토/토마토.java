import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static class Node{
		int x;
		int y;
		int day;
		public Node(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
	static int ans;
	static boolean check;
	static Queue<Node> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					q.add(new Node(i,j,0));
					visited[i][j] = true;
				}
			}
		}
		
		bfs();
		
		if(check()) {
			System.out.println(ans);
		}else {
			System.out.println(-1);
		}
	}
	public static void bfs() {
		while(!q.isEmpty()) {
			Node now = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(visited[nx][ny] || map[nx][ny] == -1) continue;
				map[nx][ny] = 1;
				q.add(new Node(nx, ny, now.day + 1));
				visited[nx][ny] = true;
			}
			ans = now.day;
		}
	}
	public static boolean check() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

}