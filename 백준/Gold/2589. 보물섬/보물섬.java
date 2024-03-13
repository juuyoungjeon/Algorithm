import java.util.*;
import java.io.*;

public class Main {
	static int L, W;
	static Character[][] map;
	static boolean[][] visited;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static int max = Integer.MIN_VALUE;
	static int cnt = 0;
	static class Node{
		int x, y,cost;
		public Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new Character[L][W];
		
		for(int i = 0; i < L; i++) {
			String str = br.readLine();
			for(int j = 0; j < W; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i < L; i++) {
			for(int j = 0; j < W; j++) {
				if(map[i][j].equals('L')) {
					visited = new boolean[L][W];
					int len = bfs(i,j);
					max = Math.max(len, max);
				}
			}
		}
		
		System.out.println(max);
		
	}
	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y,0));
		visited[x][y] = true;
		
		int len = 0;
		while(!q.isEmpty()) {
			Node now = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx < 0 || nx >= L || ny < 0 || ny >= W) continue;
				if(visited[nx][ny] || map[nx][ny].equals('W')) continue;
				q.add(new Node(nx, ny, now.cost + 1));
				len = Math.max(len, now.cost + 1);
				visited[nx][ny] = true;
			}
		}
		
		return len;
	}

}