import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map;
	static class Node{
		int x;
		int y;
		int time;
		
		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
		
	}
	static ArrayList<Node> list;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	static int min = Integer.MAX_VALUE;
	static Node[] virus;
	static int empty;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		virus = new Node[M];
		list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					list.add(new Node(i, j, 0));
				}
				if(map[i][j] == 0) {
					empty++;
				}
				
			}
		}
		if(empty == 0) {
			System.out.println(0);
		}else {
			select(0,0);
			System.out.println(min == Integer.MAX_VALUE? -1 : min);
		}
	}
	public static void select(int depth, int start) {
		if(depth == M) {
			bfs(empty);
			return;
		}
		
		for(int i = start; i < list.size(); i++) {
			virus[depth] = list.get(i);
			select(depth + 1, i + 1);
		}
	}
	public static void bfs(int cnt) {
		Queue<Node> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		for(Node v : virus) {
			q.add(new Node(v.x, v.y, 0));
			visited[v.x][v.y] = true;
		}
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1 || visited[nx][ny] || map[nx][ny] == 1) continue;
				
				q.add(new Node(nx, ny, cur.time + 1));
				visited[nx][ny] = true;
				
				if(map[nx][ny] == 0) {
					cnt--;
				}
				
				if(cnt == 0) {
					min = Math.min(min, cur.time + 1);
					return;
				}
				
			}
		}
	}

}