import java.util.*;
import java.io.*;

public class Main {
	static class Point{
		int num;
		double x;
		double y;
		
		public Point(int num, double x, double y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		double weight;
		
		public Edge(int start, int end, double weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			if(weight < o.weight) {
				return -1;
			}
			return 1;
		}
		
	}
	static int[] parent;
	static ArrayList<Edge> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Point[] points = new Point[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			
			points[i] = new Point(i,x,y);
		}
		
		list = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {				
				double weight = distance(points[i], points[j]);
				
				list.add(new Edge(points[i].num, points[j].num, weight));
			}
		}
		Collections.sort(list);
		
		parent = new int[N];
		for(int i = 0; i < N; i++) {
			parent[i] = i;
		}
		
		double ans = 0;
		
		for(int i = 0; i < list.size(); i++) {
			Edge edge = list.get(i);
			if(find(edge.start) != find(edge.end)) {
				ans += edge.weight;
				union(edge.start, edge.end);
			}
		}
		
		System.out.println(ans);
	}
	public static double distance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}
	public static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) {
			parent[y] = x;
		}
	}

}