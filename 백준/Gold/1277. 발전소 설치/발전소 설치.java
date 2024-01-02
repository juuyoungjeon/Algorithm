import java.util.*;
import java.io.*;

public class Main {
	static int N, W;
	static double M;
	static double[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int INF = 987654321;
	static class Point implements Comparable<Point>{
		int no;
		int x;
		int y;
		double dist;
		
		public Point(int no, int x, int y) {
			this.no = no;
			this.x = x;
			this.y = y;
		}
		public Point(int no, double dist) {
			this.no = no;
			this.dist = dist;
		}
		
		public double getDistance(Point o) {
			long d1 = this.x - o.x;
			long d2 = this.y - o.y;
			return Math.sqrt(d1*d1 + d2*d2);
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return Double.compare(this.dist, o.dist);
		}
		
	}
	static Point[] points;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		M = Double.parseDouble(br.readLine());
		
		//map = new int[N + 1][2];
		points = new Point[N + 1];
		for(int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			points[i] = new Point(i, x, y);
		}
		
		map = new double[N + 1][N + 1];
		for(double[] row : map) {
			Arrays.fill(row, INF);
		}
		
		for(int i = 1; i < N + 1; i++) {
			Point p1 = points[i];
			for(int j = 1; j < N + 1; j++) {
				if( i != j) {
					Point p2 = points[j];
					
					double distance = p1.getDistance(p2);
					
					if(distance > M) {
						continue;
					}else {
						map[j][i] = map[i][j] = distance;
					}
				}
			}
		}
		
		for(int i = 0; i < W; i++){
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			map[p1][p2] = map[p2][p1] = 0;
		}
		
		dijkstra();

	}
	static void dijkstra() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		Point[] dist = new Point[N + 1];
		for(int i = 1; i < dist.length; i++) {
			Point p = new Point(i, INF);
			if(i == 1) {
				p.dist = 0;
				pq.offer(p);
			}
			dist[i] = p;
		}
		
		while(!pq.isEmpty()) {
			Point front = pq.poll();
			
			for(int i = 1; i < dist.length; i++) {
				if(map[front.no][i] != INF && dist[i].dist > dist[front.no].dist + map[front.no][i]) {
					dist[i].dist = dist[front.no].dist + map[front.no][i];
					pq.offer(dist[i]);
				}
			}
		}
		System.out.println(dist[N].dist == INF ? -1 : (int)(dist[N].dist * 1000));
	}

}