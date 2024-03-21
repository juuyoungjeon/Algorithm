import java.util.*;
import java.io.*;

public class Main {

	static class Node{
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static ArrayList<Node> student = new ArrayList<>();
	static int N;
	static char[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'S') {
					student.add(new Node(i, j));
				}
			}
		}
		dfs(0);
		System.out.println("NO");
	}

	private static void dfs(int wall) {
		if(wall == 3) {
			bfs();
			return;
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 'X') {
					map[i][j] = 'O';
					dfs(wall + 1);
					map[i][j] = 'X';
				}
			}
		}
	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
		char[][] copyMap = new char[N][N];
		boolean[][] visited = new boolean[N][N];

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(copyMap[i][j] == 'T') {
					q.add(new Node(i, j));
					visited[i][j] = true;
				}
			}
		}

		while(!q.isEmpty()) {
			Node now = q.poll();
			int x = now.x;
			int y = now.y;

			for(int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];

				while(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if(copyMap[nx][ny] != 'O') {
						visited[nx][ny] = true;
						nx += dx[k];
						ny += dy[k];
					}
					else {
						break;
					}
				}
			}
		}
		if(catchStudent(visited)) {
			System.out.println("YES");
			System.exit(0);
		}

	}

	private static boolean catchStudent(boolean[][] visited) {
		for(Node node : student) {
			if(visited[node.x][node.y] == true) {
				return false;
			}
		}
		return true;
	}

}