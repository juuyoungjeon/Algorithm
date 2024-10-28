import java.util.*;
import java.io.*;



public class Main {

	static class Point {
		int x,y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int x,y,ex,ey,N;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,-2,-2,-1,1,2,2,1};
	static int[] dy = {-2,-1,1,2,2,1,-1,-2};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		while(T-->0) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			visited = new boolean[N][N];
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			visited[x][y] = true;

			st = new StringTokenizer(br.readLine());
			ex = Integer.parseInt(st.nextToken());
			ey = Integer.parseInt(st.nextToken());

			bfs();

		}

	}
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x,y));

		while(!q.isEmpty()) {
			int len = q.size();
			for(int i = 0; i < len; i++) {
				Point p = q.poll();
				if(p.x == ex && p.y == ey) break;

				for(int j = 0; j < 8; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];

					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					if(!visited[nx][ny] && arr[nx][ny] == 0) {
						visited[nx][ny] = true;
						arr[nx][ny] = arr[p.x][p.y] + 1;
						q.offer(new Point(nx,ny));
					}
				}
			}
		}
		System.out.println(arr[ex][ey]);
	}

}