import java.util.*;
import java.io.*;

public class Main {
	static int N, M, cnt;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static char[][] map;
	static ArrayList<Node> node;
	static boolean[][] visited;
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		node = new ArrayList<>();
		map = new char[N][M];
		visited = new boolean[N][M];
		
		cnt = 0;
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				
				if(map[i][j] == 'I') {
					node.add(new Node(i,j));
				}
			}
		}
		
		dfs(node.get(0).x, node.get(0).y);
		
		if(cnt == 0) {
			System.out.println("TT");
		}else {
			System.out.println(cnt);
			
		}
		
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		if(map[x][y] == 'P') cnt++;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
				if(map[nx][ny] != 'X') {
					dfs(nx,ny);
				}
			}
		}
	}

}