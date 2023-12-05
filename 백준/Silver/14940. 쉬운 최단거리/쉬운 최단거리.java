import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[][] map;
	static int[][] dist;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dist = new int[N][M];
		visited = new boolean[N][M];
		
		int startX = -1;
		int startY = -1;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					startX = i;
					startY = j;
				}
			}
		}
		
		bfs(startX, startY);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					sb.append("-1" + " ");
				}else {
					sb.append(dist[i][j] + " ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
				if(map[nx][ny] == 0) continue;
				if(visited[nx][ny]) continue;
				
				q.add(new Node(nx,ny));
				dist[nx][ny] = dist[now.x][now.y] + 1;
				visited[nx][ny] = true;
			}
		}
		
	}
}