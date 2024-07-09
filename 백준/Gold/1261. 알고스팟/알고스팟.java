import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int ans;
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cnt;
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Node o) {
			return this.cnt - o.cnt;
		}
	}
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		bfs(0,0);
		
		System.out.println(ans);
	}
	public static void bfs(int x, int y) {
		Queue<Node> q = new PriorityQueue<>();
		q.add(new Node(x,y,0));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			if(now.x == N - 1 && now.y == M - 1) {
				ans = now.cnt;
			}
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
				if(visited[nx][ny]) continue;
//				if(map[nx][ny] == 1) now.cnt += 1;
//				q.add(new Node(nx, ny, now.cnt));
//				visited[nx][ny] = true;
				if(map[nx][ny] == 1) {
					q.add(new Node(nx, ny, now.cnt + 1));
					visited[nx][ny] = true;
				}else {
					q.add(new Node(nx,ny,now.cnt));
					visited[nx][ny] = true;
				}
			}
		}
	}
	

}