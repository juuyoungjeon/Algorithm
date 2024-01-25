import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K, ans;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = 1;
		}
		ans = 0;
		for(int i=1;i<N+1;i++) {
			for(int j=1;j<M+1;j++) {
				if(arr[i][j]==1) {
					bfs(i,j);
				}
			}
		}
		
		System.out.println(ans);
		
	}
	public static void bfs(int x,int y) {
		Queue<int []> q = new ArrayDeque<>();
		q.add(new int[] {x, y});
		visited[x][y] = true;
		int cnt=0;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			visited[nowX][nowY]=true;
			cnt++;
			for(int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX > 0 && nextY > 0 && nextX <= N && nextY <= M && !visited[nextX][nextY] && arr[nextX][nextY] ==1) {
					q.add(new int[] {nextX, nextY});
					visited[nextX][nextY] = true;
				}
			}
			
		}
		ans=Math.max(ans,cnt);
	}

}