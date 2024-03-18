import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static int ans;
	static class Node{
		int x;
		int y;
		int cnt;
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				arr[i][j] = Character.getNumericValue(s.charAt(j));
			}
		}
//		ans = Integer.MIN_VALUE;
		ans = 0;
		bfs();
		System.out.println(ans);
		
	}
	public static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0,0,1));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) continue;
				if(visited[nx][ny] || arr[nx][ny] == 0) continue;
				
				q.add(new Node(nx, ny, now.cnt + 1));
				visited[nx][ny] = true;
			}
			
			if(now.x == N - 1 && now.y == M - 1) {
//				ans = Math.max(ans, now.cnt);
				ans = now.cnt;
			}
		}
	}

}