import java.util.*;
import java.io.*;

public class Main {
	static int n, m, cnt = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[][] visited;
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][m+1];
		visited = new boolean[n+1][m+1];
		
		for(int i = 1; i <= n; i++) {
			String s = br.readLine();
			for(int j = 1; j <= m; j++) {
				arr[i][j] = s.charAt(j - 1) -'0';
			}
		}
		bfs();
		System.out.println(cnt);
	}
	public static void bfs() {
		Queue<Node> q = new PriorityQueue<>();
		q.add(new Node(1,1,0));
		visited[1][1] = true;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			if(now.x == n && now.y == m) {
//				return now.cost;
				cnt = now.cost;
			}
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				
				if(nx < 1 || nx > n || ny < 1 || ny > m) continue;
				if(visited[nx][ny]) continue;
				if(arr[nx][ny] == 1) {
					q.add(new Node(nx, ny, now.cost + 1));
					visited[nx][ny] = true;
				}else {
					q.add(new Node(nx, ny, now.cost));
					visited[nx][ny] = true;
				}
				
			}
		}
//		return 0;
	}
}