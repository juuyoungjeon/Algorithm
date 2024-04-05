import java.io.*;
import java.util.*;

public class Main {

	static class Robot implements Comparable<Robot>{
		int node;
		int dis;
		
		public Robot(int node, int dis) {
			this.node = node;
			this.dis = dis;
		}

		@Override
		public int compareTo(Robot o) {
			return Integer.compare(this.dis, o.dis);
		}
	}
	
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	static int[][] map;
	static boolean[][] visit;
	static boolean flag;
	static int N,KEY,cnt=1,dis;
	static PriorityQueue<Robot> pq = new PriorityQueue<>();
	static Queue<int[]> q = new LinkedList<>();
	static ArrayList<ArrayList<Robot>> graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		KEY = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if(ch[j] == '1') map[i][j] = -2;
				if(ch[j] == '0') map[i][j] = -1;
				if(ch[j] == 'S' || ch[j] == 'K') {
					if(ch[j] == 'S') {
						map[i][j] = 0;
					}else {
						map[i][j] = cnt++;
					}
					q.add(new int[] {i,j});
				}
			}
		}
		
		//그래프 초기화
		graph = new ArrayList<>();
		for (int i = 0; i < q.size(); i++) {
			graph.add(new ArrayList<>());
		}
		
		//간선 생성
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			bfs(pos[0], pos[1]);
		}
		
		if(Prim()) System.out.println(dis);
		else	   System.out.println(-1);
	}

	private static boolean Prim() {
		boolean[] visit = new boolean[KEY+1];
		int cnt = 0;
		pq.add(new Robot(0,0));
		
		while(!pq.isEmpty()) {
			Robot robot = pq.poll();
			
			//방문했으면 continue
			if(visit[robot.node]) continue;
			visit[robot.node] = true;
			dis+= robot.dis;
			
			if(++cnt == KEY+1) { 
				return true;
			}
				
			//정점과 연결된 모든 정점을 순회
			for(Robot next : graph.get(robot.node)) {
				pq.add(next);
			}
		}
		return false;
	}

	private static void bfs(int row, int col) {
		Queue<int[]> q = new LinkedList<>();
		visit = new boolean[N][N];
		q.add(new int[] {row,col,0});
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = pos[0] + dx[i];
				int ny = pos[1] + dy[i];
				
				//맵밖
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				//방문
				if(visit[nx][ny]) continue; 
				//벽
				if(map[nx][ny] == -2) continue;
				//key를 발견했을 때
				if(map[nx][ny] > 0) {
					graph.get(map[row][col]).add(new Robot(map[nx][ny],pos[2]+1));
				}
				//방문처리
				visit[nx][ny] = true;
				q.add(new int[] {nx,ny,pos[2]+1});
			}
		}
	}
}